package com.ezen.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestScheduler {

	// cron ="초 분 시 일 월 주"
	@Scheduled(cron="0 0 1 * * *")
	public void test() {
		log.debug("schedule test");
	}
}
