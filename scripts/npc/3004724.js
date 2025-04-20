﻿importPackage(Packages.client.inventory);
importPackage(Packages.client);
importPackage(Packages.server);
importPackage(Packages.tools.packet);
importPackage(Packages.constants);
importPackage(Packages.server.quest);

var enter = "\r\n";
var seld = -1;

var bjob = -1;
var cjob = -1;
var adv = false;
검정 = "#fc0xFF191919#";
회색 = "#fc0xFFB4B4B4#";


var jobs = [
	{ 'jobid': 110, 'jobname': "히어로", 'job': "모험가", 'stat': 1, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 120, 'jobname': "팔라딘", 'job': "모험가", 'stat': 1, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 130, 'jobname': "다크나이트", 'job': "모험가", 'stat': 1, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 210, 'jobname': "불독", 'job': "모험가", 'stat': 3, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 220, 'jobname': "썬콜", 'job': "모험가", 'stat': 3, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 230, 'jobname': "비숍", 'job': "모험가", 'stat': 3, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 310, 'jobname': "보우마스터", 'job': "모험가", 'stat': 2, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 320, 'jobname': "신궁", 'job': "모험가", 'stat': 2, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 330, 'jobname': "패스파인더", 'job': "모험가", 'stat': 2, 'sk': [80001152, 1281, 1297, 1298, 12, 73] },
	{ 'jobid': 410, 'jobname': "나이트로드", 'job': "모험가", 'stat': 2, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 420, 'jobname': "섀도어", 'job': "모험가", 'stat': 4, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 430, 'jobname': "듀얼블레이드", 'job': "모험가", 'stat': 4, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 510, 'jobname': "바이퍼", 'job': "모험가", 'stat': 1, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 520, 'jobname': "캡틴", 'job': "모험가", 'stat': 2, 'sk': [80001152, 1281, 12, 73] },
	{ 'jobid': 530, 'jobname': "캐논슈터", 'job': "모험가", 'stat': 1, 'sk': [80001152, 1281, 110, 109, 111, 1283, 12, 73] },
	{ 'jobid': 1100, 'jobname': "소울마스터", 'job': "시그너스", 'stat': 1, 'sk': [10001244, 10000252, 80001152, 10001253, 10001254, 10001245, 10000250, 10000246, 10000012, 10000073] },
	{ 'jobid': 1200, 'jobname': "플레임위자드", 'job': "시그너스", 'stat': 3, 'sk': [10001244, 10000252, 80001152, 10001253, 10001254, 10001245, 10000250, 10000248, 10000012, 10000073] },
	{ 'jobid': 1300, 'jobname': "윈드브레이커", 'job': "시그너스", 'stat': 2, 'sk': [10001244, 10000252, 80001152, 10001253, 10001254, 10001245, 10000250, 10000247, 10000012, 10000073] },
	{ 'jobid': 1400, 'jobname': "나이트워커", 'job': "시그너스", 'stat': 4, 'sk': [10001244, 10000252, 80001152, 10001253, 10001254, 10001245, 10000250, 10000249, 10000012, 10000073] },
	{ 'jobid': 1500, 'jobname': "스트라이커", 'job': "시그너스", 'stat': 1, 'sk': [10001244, 10000252, 80001152, 10001253, 10001254, 10001245, 10000250, 10000246, 10000012, 10000073] },
	{ 'jobid': 5100, 'jobname': "미하일", 'job': "시그너스", 'stat': 1, 'sk': [50001214, 10000250, 10000074, 10000075, 50000012, 50000073] },
	{ 'jobid': 2100, 'jobname': "아란", 'job': "영웅", 'stat': 1, 'sk': [20000194, 20001295, 20001296, 20000012, 20000073] },
	{ 'jobid': 2200, 'jobname': "에반", 'job': "영웅", 'stat': 3, 'sk': [20010022, 20010194, 20011293, 20010012, 20010073] },
	{ 'jobid': 2300, 'jobname': "메르세데스", 'job': "영웅", 'stat': 2, 'sk': [20020109, 20021110, 20020111, 20020112, 20020012, 20020073] },
	{ 'jobid': 2400, 'jobname': "팬텀", 'job': "영웅", 'stat': 4, 'sk': [20031208, 20040190, 20031203, 20031205, 20030206, 20031207, 20031209, 20031251, 20031260, 20030012, 20030073] },
	{ 'jobid': 2500, 'jobname': "은월", 'job': "영웅", 'stat': 1, 'sk': [20051284, 20050285, 20050286, 20050074, 20050012, 20050073] },
	{ 'jobid': 2700, 'jobname': "루미너스", 'job': "영웅", 'stat': 3, 'sk': [20040216, 20040217, 20040218, 20040219, 20040221, 20041222, 20040012, 20040073] },
	{ 'jobid': 14200, 'jobname': "키네시스", 'job': "영웅", 'stat': 3, 'sk': [140000291, 14200, 14210, 14211, 14212, 140001290, 140000012, 140000073] },
	{ 'jobid': 3200, 'jobname': "배틀메이지", 'job': "레지스탕스", 'stat': 3, 'sk': [30001281, 30000012, 30000073] },
	{ 'jobid': 3300, 'jobname': "와일드헌터", 'job': "레지스탕스", 'stat': 2, 'sk': [30001281, 30001062, 30001061, 30000012, 30000073] },
	{ 'jobid': 3500, 'jobname': "메카닉", 'job': "레지스탕스", 'stat': 2, 'sk': [30001281, 30001068, 30000227, 30000012, 30000073] },
	{ 'jobid': 3600, 'jobname': "제논", 'job': "레지스탕스", 'stat': 5, 'sk': [30001281, 30020232, 30020233, 30020234, 30020240, 30021235, 30021236, 30021237, 30020012, 30020073] },
	{ 'jobid': 3100, 'jobname': "데몬슬레이어", 'job': "레지스탕스", 'stat': 1, 'sk': [30001281, 80001152, 30001061, 30010110, 30010185, 30010112, 30010111, 30010012, 30010073] },
	{ 'jobid': 3101, 'jobname': "데몬어벤저", 'job': "레지스탕스", 'stat': 6, 'sk': [30001281, 80001152, 30001061, 30010110, 30010185, 30010242, 30010241, 30010230, 30010231, 30010232, 30010012, 30010073] },
	{ 'jobid': 6100, 'jobname': "카이저", 'job': "노바", 'stat': 1, 'sk': [600000219, 60000222, 60001217, 60001216, 60001225, 60001005, 60001296, 60000012, 60000073] },
	{ 'jobid': 6400, 'jobname': "카데나", 'job': "노바", 'stat': 4, 'sk': [60020216, 60021217, 60021005, 60020218, 60020012, 60020073] },
	{ 'jobid': 6300, 'jobname': "카인", 'job': "노바", 'stat': 2, 'sk': [60031005, 60030012, 60030073] },
	{ 'jobid': 6500, 'jobname': "엔젤릭버스터", 'job': "노바", 'stat': 2, 'sk': [60011216, 60010217, 60011218, 60011219, 60011220, 60011221, 60011222, 60011005, 60010012, 60010073] },
	{ 'jobid': 15100, 'jobname': "아델", 'job': "레프", 'stat': 1, 'sk': [150020041, 150021000, 150020079, 150020006, 150020241] },
	{ 'jobid': 15500, 'jobname': "아크", 'job': "레프", 'stat': 1, 'sk': [150010079, 150011005, 150011074, 150010241, 150010012, 150010073] },
	{ 'jobid': 16400, 'jobname': "호영", 'job': "아니마", 'stat': 4, 'sk': [160001074, 160001075, 160001005, 160000000, 160000076, 160000012, 160000073, 164001004] },
	{ 'jobid': 16200, 'jobname': "라라", 'job': "아니마", 'stat': 4, 'sk': [160010000, 160011075] }
]

function start() {
	status = -1;
	action(1, 0, 0);
}

function action(mode, type, sel) {
	if (mode == 1) {
		status++;
	} else {
		cm.dispose();
		return;
	}
	if (status == 0) {
		var 게임약관 = "#fs14#你好, 歡迎來到百合子的楓之谷\r\n";
		게임약관 += "" + 회색 + "────────────────────────────\r\n";
		게임약관 += " " + 검정 + "服務器設置:\r\n";
		게임약관 += " " + 검정 + "3倍經驗;5倍楓幣;楓幣可以購買全部魔方!\r\n";
		게임약관 += " " + 검정 + "刷怪數量雙倍;怪刷新時間減半;快樂打怪!\r\n";
		게임약관 += " " + 검정 + "強化全部用痕跡; 痕跡提供強力屬性!\r\n";
		게임약관 += " " + 검정 + "神秘球/技能核心/真實球打怪掉落; 上線送P寵!\r\n";
		게임약관 += " " + 검정 + "自動轉職, 自動學技能, 簡化遊戲流程!\r\n";
		게임약관 += "" + 회색 + "────────────────────────────\r\n";

		cm.sendYesNoS(게임약관, 0x4);
	} else if (status == 1) {
		if (GameConstants.isYeti(cm.getPlayer().getJob())) {
			cm.gainItem(2000054, 1);
			cm.gainMeso(3000000);
			cm.gainItem(2431774, 1);
                                         cm.gainItem(2433444, 1);
                        cm.gainItem(3700666, 1);
			cm.getPlayer().AutoTeachSkill();
			cm.warp(100000000);
			cm.getPlayer().resetStats(4, 4, 4, 4);
			cm.openNpc(2007, "YetiTuto0");
			return;
		} else if (GameConstants.isPinkBean(cm.getPlayer().getJob())) {
			cm.gainItem(2000054, 1);
			cm.gainMeso(3000000);
			cm.gainItem(2431774, 1);
                                         cm.gainItem(2433444, 1);
                        cm.gainItem(3700666, 1);
			cm.getPlayer().AutoTeachSkill();
			cm.warp(100000000);
			cm.getPlayer().resetStats(4, 4, 4, 4);
			cm.openNpc(2007, "PinkBeanTuto0");
			return;
		}
		FirstJob(cm.getJob());
	} else if (status == 2) {
		seld = sel;
		if (seld >= 1 && seld <= 5) {
			adv = true;
			cm.sendSimple(SecondJob(seld));
		} else {
			nocast = false;
			switch (cm.getJob()) {

				case 2000:
					cm.teachSkill(20001295, 1, 1);
					break;

				case 6000:
					cm.teachSkill(60000219, 1, 1);
					cm.teachSkill(60001217, 1, 1);
					cm.teachSkill(60001216, 1, 1);
					cm.teachSkill(60001218, 1, 1);
					cm.teachSkill(60001219, 1, 1);
					cm.teachSkill(60001225, 1, 1);
					cm.addEquip(-10, 1352500, 0, 0, 0, 0, 0, 0);
					break;

				case 6001:
					cm.addEquip(-10, 1352601, 0, 0, 0, 0, 0, 0);
					break;

				case 2004:
					cm.teachSkill(27000106, 5, 5);
					cm.teachSkill(27000207, 5, 5);
					cm.teachSkill(27001201, 20, 20);
					cm.teachSkill(27001100, 20, 20);
					break;
				case 2005:
					cm.teachSkill(20051284, 30, 30);
					cm.teachSkill(20050285, 30, 30);
					cm.teachSkill(20050286, 30, 30);
					//cm.teachSkill(25000003, 30, 30);
					break;

				case 1000:
					cm.teachSkill(10001251, 1, 1);
					cm.teachSkill(10001252, 1, 1);
					cm.teachSkill(10001253, 1, 1);
					cm.teachSkill(10001254, 1, 1);
					cm.teachSkill(10001255, 1, 1);
					break;
				case 15002:
					cm.teachSkill(151001004, 1, 1);
					break;
			}
			switch (seld) {
				case 330:
					cjob = 301;
					cm.getPlayer().setReborns(sel);
					cm.getPlayer().setAutoJob(330);
					nocast = true;
					break;
				case 430:
					nocast = true;
					cjob = sel - 30;
					cm.getPlayer().changeJob(400);
					cm.getPlayer().setAutoJob(430);
					cm.teachSkill(263, 1, 2);
					cm.getPlayer().setReborns(sel);
					break;

				case 530:
					cjob = 501;
					cm.teachSkill(266, 1, 2);
					cm.getPlayer().setReborns(sel);
					cm.getPlayer().setAutoJob(530);
					nocast = true;
					break;

				case 1100:
					cm.teachSkill(10000255, 1, 2);
					break;
				case 1200:
					cm.teachSkill(10000256, 1, 2);
					break;
				case 1300:
					cm.teachSkill(10000257, 1, 2);
					break;
				case 1400:
					cm.teachSkill(10000258, 1, 2);
					break;
				case 1500:
					cm.teachSkill(10000259, 1, 2);
					break;

				case 3200:
					cm.teachSkill(30000074, 1, 2);
					break;
				case 3300:
					cm.teachSkill(30000074, 1, 2);
					break;
				case 3700:
					cm.teachSkill(30000077, 1, 2);
					break;

				case 14000:
					cm.teachSkill(140000291, 6, 6);
					break;

				case 15000:
					cm.teachSkill(150000079, 1, 1);
					cm.teachSkill(150011005, 1, 1);
					break;

				case 16000:
					cm.teachSkill(160000001, 1, 1);

					break;

				case 16001:
					cm.teachSkill(160010000, 1, 1);

					break;


				case 3100:
					cm.teachSkill(30010112, 1, 2);
					cm.addEquip(-10, 1099000, 0, 0, 0, 0, 0, 0);
					break;

				case 3101:
					cm.getPlayer().setAutoJob(3120);
					cm.teachSkill(30010241, 1, 2);
					cm.getPlayer().setHair(36460);
					cm.getPlayer().setFace(20284);
					cm.addEquip(-5, 1050249, 0, 0, 0, 0, 0, 0);
					cm.addEquip(-7, 1070029, 0, 0, 0, 0, 0, 0);
					cm.addEquip(-9, 1102505, 0, 0, 0, 0, 0, 0);
					cm.addEquip(-10, 1099000, 0, 0, 0, 0, 0, 0);
					cm.addEquip(-11, 1232000, 0, 0, 0, 0, 0, 0);
					cm.getPlayer().fakeRelog();
					nocast = true;
					break;

				case 3500:
					cm.teachSkill(30000076, 1, 2);
					cm.teachSkill(30001068, 1, 1);
					break;

				case 10112:
					cm.getPlayer().setAutoJob(110112);
					cm.addEquip(-10, 1562000, 97, 0, 0, 0, 0, 0);
					cm.addEquip(-11, 1572000, 95, 0, 0, 0, 0, 0);
					nocast = true;
					break;
			}

			if (cjob == -1) {
				cjob = seld;
			}
			if (seld == 15200) {
				for (var a = 34900; a < 34950; a++) {
					if (cm.getPlayer().getQuestStatus(a) != 2) {
						MapleQuest.getInstance(a).forceComplete(cm.getPlayer(), 0);
					}
				}
			}
			for (i = 0; i < jobs.length; i++) {
				if (jobs[i]['jobid'] == cjob) {
					for (j = 0; j < jobs[i]['sk'].length; j++) {
						cm.teachSkill(jobs[i]['sk'][j], 30, 30);
					}
					break;
				}
			}
			if (!nocast) {
				job = cjob + 10;
				cm.getPlayer().setAutoJob(job);
			}

			cm.dispose();

			if (seld != 430)
				cm.changeJob(cjob);
                                           addMedal();
										   addPet();
			cm.gainItem(5044002, 1);
			cm.gainItem(2000005, 500);
			cm.gainItem(2450163, 3);
                                           cm.gainItem(3018469, 1);
                                          cm.gainItem(2431307, 1);
			cm.gainMeso(3000000);
			cm.gainItem(2431774, 1);
                                         cm.gainItem(2433444, 1);
                        cm.gainItem(3700666, 1);
			cm.getPlayer().AutoTeachSkill();
			max = seld == 2500 || seld == 430 ? 20 : 10;
			if (seld != 10112) {
				for (var i = cm.getPlayer().getLevel(); i < max; i++) {
					cm.gainExp(Packages.constants.GameConstants.getExpNeededForLevel(i));
				}
			}
			cm.warp(100000000, 0);
			cm.getPlayer().resetStats(4, 4, 4, 4);
			//cm.JoinNubGuild();
			cm.dispose();
			//cm.openNpc(2008, "tutorial");
		}
	} else if (status == 3) {
		if (adv) {
			switch (sel) {
				case 110:
					cm.teachSkill(252, 1, 2);
					cjob = 100;
					break;
				case 120:
					cm.teachSkill(253, 1, 2);
					cjob = 100;
					break;
				case 130:
					cm.teachSkill(254, 1, 2);
					cjob = 100;
					break;
				case 210:
					cm.teachSkill(255, 1, 2);
					cjob = 200;
					break;
				case 220:
					cm.teachSkill(256, 1, 2);
					cjob = 200;
					break;
				case 230:
					cm.teachSkill(257, 1, 2);
					cjob = 200;
					break;
				case 310:
					cm.teachSkill(258, 1, 2);
					cjob = 300;
					break;
				case 320:
					cm.teachSkill(259, 1, 2);
					cjob = 300;
					break;
				case 330:
					cm.getPlayer().setAutoJob(330);
					cm.teachSkill(260, 1, 2);
					break;
				case 410:
					cm.teachSkill(261, 1, 2);
					cjob = 400;
					break;
				case 420:
					cm.teachSkill(262, 1, 2);
					cjob = 400;
					break;
				case 510:
					cm.teachSkill(264, 1, 2);
					cjob = 500;
					break;
				case 520:
					cm.teachSkill(265, 1, 2);
					cjob = 500;
					break;
			}
			for (i = 0; i < jobs.length; i++) {
				if (jobs[i]['jobid'] == sel) {
					for (j = 0; j < jobs[i]['sk'].length; j++) {
						cm.teachSkill(jobs[i]['sk'][j], 30, 30);
					}
					break;
				}
			}
			for (var i = cm.getPlayer().getLevel(); i < 10; i++) {
				cm.gainExp(Packages.constants.GameConstants.getExpNeededForLevel(i));
			}
			cm.warp(100000000, 0);
			cm.getPlayer().resetStats(4, 4, 4, 4);
			cm.dispose();
			cm.changeJob(cjob);
			if (sel != 330) {
				cm.getPlayer().setAutoJob(sel);
			}
			cm.getPlayer().setReborns(sel);
			cm.getPlayer().AutoTeachSkill();
			addMedal();
			addPet();
			cm.gainItem(2632124, 1);
                                           cm.gainItem(2431307, 1);
                                         cm.gainItem(2433444, 1);
                                         cm.gainItem(3018469, 1);
										 cm.gainItem(2450163, 3);
										 cm.gainItem(2000005, 500);
			cm.gainItem(2431774, 1);
			cm.gainItem(5044002, 1);
                        cm.gainItem(3700666, 1);
			cm.gainMeso(3000000);
			//cm.JoinNubGuild();
			//cm.openNpc(2008, "tutorial");
		}
	}
}

function SecondJob(i) {
	var adventure = "#fs14##b#h ##k 請選擇職業!" + enter;
	switch (i) {
		case 1:
			adventure += "#L110# #r英雄!\r\n";
			adventure += "#L120# #r聖騎士!\r\n";
			adventure += "#L130# #r黑騎士!\r\n";
			break;
		case 2:
			adventure += "#L210# #r大魔導士(火、毒)!\r\n";
			adventure += "#L220# #r大魔導士(冰、雷)!\r\n";
			adventure += "#L230# #r主教!\r\n";
			break;
		case 3:
			adventure += "#L210# #r箭神(弓)!\r\n";
			adventure += "#L320# #r神射手(弩)!\r\n";
			break;
		case 4:
			adventure += "#L410# #r夜使者(標飛)!\r\n";
			adventure += "#L420# #r暗影神偷(刀飛)!\r\n";
			break;
		case 5:
			adventure += "#L510# #r拳霸(衝鋒隊長)!\r\n";
			adventure += "#L520# #r槍神(船長)!\r\n";
			break;
	}
	return adventure;
}

function FirstJob(i) {
	var chat = "#fs14##b#h ##k 請選擇職業!" + enter;
	switch (i) {
		case 0:
			chat += "#L1# #r冒險家戰士!\r\n";
			chat += "#L2# #r冒險家魔法師!\r\n";
			chat += "#L3# #r冒險家弓箭手!\r\n";
			chat += "#L4# #r冒險家飛俠!\r\n";
			chat += "#L5# #r冒險家海盜!\r\n";
			chat += "#L330# #r開拓者!\r\n";
			chat += "#L430# #r影武者!\r\n";
			chat += "#L530# #r重砲指揮官!\r\n";
			break;
		case 1000:
		    chat += "#L1100# #r聖魂劍士!\r\n";
			chat += "#L1200# #烈焰巫師!\r\n";
			chat += "#L1300# #破風使者!\r\n";
			chat += "#L1400# #暗夜行者!\r\n";
			chat += "#L1500# #閃雷悍將!\r\n";
			break;
		case 2000:
			chat += "#L2100# #狂狼勇士!\r\n";
			break;
		case 2001:
			chat += "#L2200# #龍魔導士!\r\n";
			break;
		case 2002:
			chat += "#L2200# #精靈遊俠!\r\n";
			break;
		case 2003:
			chat += "#L2300# #幻影俠盜!\r\n";
			break;
		case 2004:
			chat += "#L2400# #隱月!\r\n";
			break;
		case 2005:
			chat += "#L2500# #夜光!\r\n";
			break;
		case 3000:
			chat += "#L3200# #煉獄巫師!\r\n";
			chat += "#L3300# #狂豹獵人!\r\n";
			chat += "#L3500# #機甲戰神!\r\n";
			chat += "#L3700# #爆拳枪神!\r\n";
			break;
		case 3001:
			chat += "#L3100# #惡魔殺手(紅毛)!\r\n";
			chat += "#L3101# #惡魔復仇者(白毛)!\r\n";
			break;
		case 3002:
			chat += "#L3600# #傑諾(尖兵)!\r\n";
			break;
		case 5000:
			chat += "#L5100# #米哈逸!\r\n";
			break;
		case 6000:
			chat += "#L6100# #凱撒!\r\n";
			break;
		case 6001:
			chat += "#L6500# #天使破壞者!\r\n";
			break;
		case 6002:
			chat += "#L6400# #卡蒂娜!\r\n";
			break;
		case 6003:
			chat += "#L6300# #凱殷!\r\n";
			break;
		case 10112:
			chat += "#L10112# #神之子!\r\n";
			break;
		case 14000:
			chat += "#L14200# #凱內西斯!\r\n";
			break;
		case 15000:
			chat += "#L15200# #伊利恩!\r\n";
			break;
		case 15001:
			chat += "#L15500# #亞克!\r\n";
			break;
		case 15002:
			chat += "#L15100# #阿戴爾!\r\n";
			break;
		case 16000:
			chat += "#L16400# #虎影!\r\n";
			break;
		case 16001:
			chat += "#L16200# #菈菈!\r\n";
			break;
	}
	cm.sendOkS(chat, 0x4);
}

function addMedal()
{
	item = Packages.server.MapleItemInformationProvider.getInstance().generateEquipById(1142358, -1, false);
	item.setEnchantStr(10);
	item.setEnchantDex(10);
	item.setEnchantInt(10);
	item.setEnchantLuk(10);
	item.setEnchantWatk(10);
	item.setEnchantMatk(10);
	item.setEnchantHp(500);
	item.setEnchantMp(500);
	item.設置潛能等級(18);
	item.設置第一條主潛能(20086);
	item.設置第二條主潛能(20086);
	item.設置第三條主潛能(20086);
	Packages.server.MapleInventoryManipulator.addbyItem(cm.getClient(), item, false);
}

function addPet()
{
	Packages.server.MapleInventoryManipulator.addId_Item(cm.getClient(), 5002079, 1, "", Packages.client.inventory.MaplePet.createPet(5002079, -1), -1, "", false);
	Packages.server.MapleInventoryManipulator.addId_Item(cm.getClient(), 5002080, 1, "", Packages.client.inventory.MaplePet.createPet(5002080, -1), -1, "", false);
	Packages.server.MapleInventoryManipulator.addId_Item(cm.getClient(), 5002081, 1, "", Packages.client.inventory.MaplePet.createPet(5002081, -1), -1, "", false);
	petEquip1 = Packages.server.MapleItemInformationProvider.getInstance().generateEquipById(1802715, -1, false);
	petEquip2 = Packages.server.MapleItemInformationProvider.getInstance().generateEquipById(1802715, -1, false);
	petEquip3 = Packages.server.MapleItemInformationProvider.getInstance().generateEquipById(1802716, -1, false);
	Packages.server.MapleInventoryManipulator.addbyItem(cm.getClient(), petEquip1, false);
	Packages.server.MapleInventoryManipulator.addbyItem(cm.getClient(), petEquip2, false);
	Packages.server.MapleInventoryManipulator.addbyItem(cm.getClient(), petEquip3, false);
}
