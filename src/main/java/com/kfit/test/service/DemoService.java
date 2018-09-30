package com.kfit.test.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.kfit.test.bean.Demo;
import com.kfit.test.dao.DemoDao;
import com.kfit.test.dao.DemoRepository;

@Service
public class DemoService {
	@Resource
	private DemoRepository demoRepository;

	@Resource
	private DemoDao demoDao;

	@Resource
	private RedisTemplate<String,String> redisTemplate;
	
	
	public void test(){
		ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("mykey4", "random1="+Math.random());
		System.out.println(valueOperations.get("mykey4"));
	}
	//keyGenerator="myKeyGenerator"
	@Cacheable(value="demo") //缓存,这里没有指定key.
	public Demo findById(long id) {
		System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id="+id);
		Demo d=demoDao.getByAge(id);
		return d;
	}
	@CacheEvict(value="demo")
	public void deleteFromCache(long id) {
		System.out.println("DemoService.delete().从缓存中删除.");
	}


	@Transactional
	public void save(Demo demo){
		demoRepository.save(demo);
	}

	public Demo getByAge(long age){
		//demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
		return demoDao.getByAge(age);
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {

			if(i==3) {
				try {
					throw new Exception("as");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Exception ");
					continue;
				}
			}
			System.out.println(i);
		}
	}
}
