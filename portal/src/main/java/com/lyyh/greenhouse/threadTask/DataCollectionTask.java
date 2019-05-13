package com.lyyh.greenhouse.threadTask;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lyyh.greenhouse.dao.ClimaticDao;
import com.lyyh.greenhouse.dao.HouseDataDao;
import com.lyyh.greenhouse.pojo.Climatic;
import com.lyyh.greenhouse.pojo.ClimaticCollector;
import com.lyyh.greenhouse.pojo.ClimaticSetting;
import com.lyyh.greenhouse.pojo.NodeSetting;
import com.lyyh.greenhouse.pojo.HouseData;
import com.lyyh.greenhouse.pojo.HouseSetting;
import com.lyyh.greenhouse.util.ModbusUtil;

public class DataCollectionTask implements Runnable {
	private List<HouseSetting> houseSettings;
	private ClimaticSetting climaticSetting;
	private HouseDataDao houseDataDao;
	private ClimaticDao climaticDao;

	public DataCollectionTask() {
		super();
	}

	public DataCollectionTask(List<HouseSetting> houseSettings,ClimaticSetting climaticSetting,HouseDataDao houseDataDao,ClimaticDao climaticDao) {
		super();
		this.houseSettings = houseSettings;
		this.climaticSetting = climaticSetting;
		this.houseDataDao = houseDataDao;
		this.climaticDao = climaticDao;
	}

	@Override
	public void run() {
		try {
			while (true) {
				collectHouseData(houseSettings);
				collectClimaticData(climaticSetting);
				System.out.println("");
				// 线程休眠10秒
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
						System.out.print(i + 1 + "	");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void collectHouseData(List<HouseSetting> houseSettings) {
		if (houseSettings == null || houseSettings.size() == 0) {
			return;
		}
		List<HouseData> houseDatas = new ArrayList<HouseData>();
		// 遍历温室
		for (HouseSetting houseSetting : houseSettings) {
			String ip = houseSetting.getHs_ip();
			int port = houseSetting.getHs_port();

			// TODO 从网关查询数据
			// 与网关建立连接并获取socket输出流
			OutputStream os = ModbusUtil.getOutputStream(ip, port);
			System.out.print(os + "	");
			if (null != os) {
				// 一个温室的数据
				Integer h_id = houseSetting.getH_id();
				String zoneName = houseSetting.getZoneName();

				HouseData houseData = new HouseData();
				String hs_node = houseSetting.getHs_node();
				byte result[] = new byte[1024];
				String[] split = hs_node.split("\\.");

				try {
					// 遍历网关上的节点,
					for (String str : split) {
						byte node = (byte) Integer.parseInt(str);
						byte[] mqs = ModbusUtil.getModbusQueryStatement(node);
						os.write(mqs);
						InputStream is = ModbusUtil.getInputStream(ip, port);
//						System.out.print(is + "	");
						is.read(result);
						ModbusUtil.parseData(result, houseData);
					}

					houseData.setHouseId(h_id);
					houseData.setZoneName(zoneName);
					houseData.setTimeSpan(new Date());
					houseDatas.add(houseData);
				} catch (Exception e) {
					e.printStackTrace();
					ModbusUtil.closeConnection(ip, port);
				}
			} else {
				System.out.println("无法创建连接,请检查网关是否在线");
			}
		} // 所有温室数据封装完成
		if (houseDatas.size() != 0) {
			System.out.println(houseDatas);
			houseDataDao.insertList(houseDatas);
		}

	}

	public void collectClimaticData(ClimaticSetting climaticSetting) {
		if (climaticSetting == null) {
			return;
		}
		ClimaticCollector climaticCollector = new ClimaticCollector();

		String ip = climaticSetting.getCs_ip();
		int port = climaticSetting.getCs_port();

		// TODO 从网关查询数据
		// 与网关建立连接并获取socket输出流
		OutputStream os = ModbusUtil.getOutputStream(ip, port);
		// System.out.print(os + " ");
		if (null != os) {
			// 一个温室的数据
			String zoneName = climaticSetting.getZoneName();
			byte result[] = new byte[1024];
			List<NodeSetting> nodes = climaticSetting.getNodes();

			try {
				for (NodeSetting node : nodes) {
					if (node != null && node.getNode() != 0) {
						byte[] mqs = ModbusUtil.getModbusQueryStatement(node.getNode());
						os.write(mqs);
						InputStream is = ModbusUtil.getInputStream(ip, port);
						is.read(result);
						ModbusUtil.parseData(result, climaticCollector, node);
					}
				}
				climaticCollector.setZoneName(zoneName);
				climaticCollector.setTimeSpan(new Date());
				// System.out.println(climaticCollector);
				climaticDao.insertOne(climaticCollector);// TODO 换climatic插入的对象,
			} catch (Exception e) {
				e.printStackTrace();
				ModbusUtil.closeConnection(ip, port);
			}
		} else {
			System.out.println("无法创建连接,请检查网关是否在线");
		}
	}

	public List<HouseSetting> getHouseSettings() {
		return houseSettings;
	}

	public void setHouseSettings(List<HouseSetting> houseSettings) {
		this.houseSettings = houseSettings;
	}

	public HouseDataDao getHouseDataDao() {
		return houseDataDao;
	}

	public void setHouseDataDao(HouseDataDao houseDataDao) {
		this.houseDataDao = houseDataDao;
	}

}
