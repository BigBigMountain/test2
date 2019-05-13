package com.lyyh.greenhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyyh.greenhouse.dao.ClimaticDao;
import com.lyyh.greenhouse.dao.HouseDataDao;
import com.lyyh.greenhouse.dao.Screem8Dao;
import com.lyyh.greenhouse.dao.SettingDao;
import com.lyyh.greenhouse.pojo.ClimaticSetting;
import com.lyyh.greenhouse.pojo.HouseSetting;
import com.lyyh.greenhouse.service.CollectionDataService;
import com.lyyh.greenhouse.threadTask.DataCollectionTask;
import com.lyyh.greenhouse.threadTask.Screem8Task;

@Service
@Transactional
public class CollectionDataServiceImpl implements CollectionDataService {

	@Autowired
	private SettingDao settingDao;
	
	@Autowired
	private HouseDataDao houseDataDao;
	
	@Autowired
	private ClimaticDao climaticDao;
	
	@Autowired
	private Screem8Dao screem8Dao;
	
	@Override
	public void stopCollect() {
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		// 激活的线程数加倍
		int estimatedSize = group.activeCount() * 2;
		Thread[] slackList = new Thread[estimatedSize];
		// 获取根线程组的所有线程
		int actualSize = group.enumerate(slackList);
		// copy into a list that is the exact size
		Thread[] list = new Thread[actualSize];
		System.arraycopy(slackList, 0, list, 0, actualSize);
//		System.out.println("Thread list size == " + list.length);

		// TODO
		for (Thread thread : list) {
			String threadName = thread.getName();
			if (threadName.contains("CollectData") || threadName.contains("Screem8")) {
//				System.out.println(tname);
				thread.stop();
//				thread.destroy();
			}
		}

	}

	@Override
	public void startCollect(String zoneName) {
		List<HouseSetting> houseSettings = settingDao.queryAllActivatedHouseSettings(zoneName);
		if(houseSettings == null || houseSettings.size()==0){
			return;
		}
		
		ClimaticSetting climaticSetting = settingDao.queryClimaticSetting(zoneName);
		
		//先结束已有的DataCollect线程 TODO
		stopCollect();
		//再重新开启线程    线程"采集数据"
		String threadName = "CollectData"+zoneName;
		DataCollectionTask dataCollectionTask = new DataCollectionTask(houseSettings,climaticSetting, houseDataDao,climaticDao);
		Thread dataCollectionThread = new Thread(dataCollectionTask,threadName);
		dataCollectionThread.start();
		
//		//开启线程    8字屏显示
		String threadName2 = "Screem8"+zoneName;
		Screem8Task screem8Task = new Screem8Task(houseSettings, houseDataDao,screem8Dao, zoneName);
		Thread screem8Thread = new Thread(screem8Task,threadName2);
		screem8Thread.start();
		
	}

}
