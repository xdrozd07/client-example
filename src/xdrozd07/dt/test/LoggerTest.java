package xdrozd07.dt.test;

import static org.junit.Assert.*;

import org.junit.Test;


import xdrozd07.dt.logger.LoggerUtil;
public class LoggerTest {

	@Test
	public void test(){
		Exception e = new Exception("zprava");
		LoggerUtil.log(e);
	}

}
