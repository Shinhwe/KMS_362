importPackage(java.lang);
importPackage(java.io);

function start() {
	St = -1;
	action(1, 0, 0);
}

function action(M, T, S) {
	if (M != 1) {
		cm.dispose();
		return;
	}

	if (M == 1)
	{
		St++;
	}

	if (!cm.haveItem(2433444)) {
		cm.dispose();
		return;
	}

	if (St == 0) {
		if (cm.getPlayer().getJob() == 10112) {
			cm.sendOkS("#b#h ##k恭喜, 成功領取下列裝備!\r\n\r\n#b"
				+ "#fUI/UIWindow2.img/QuestIcon/4/0#\r\n"
				+ "  #i1003863:# #t1003863:#\r\n"
				+ "  #i1052612:# #t1052612:#\r\n"
				+ "  #i1102562:# #t1102562:#\r\n"
				+ "  #i1012376:# #t1012376:#\r\n"
				+ "  #i1122252:# #t1122252:#\r\n"
				+ "  #i1132228:# #t1132228:#\r\n", 4, 2007);
			addOption(1003863, false);
			addOption(1052612, false);
			addOption(1102562, false);
			addOption(1012376, false);
			addOption(1122252, false);
			addOption(1132228, false);
			cm.gainItem(2433444, -1);
			cm.dispose();
			return;
		}

		wList = [];
		getWeapon(cm.getPlayer().getJob());
		selStr = "#b#h ##k你好, 每個角色都可以領取一套初試裝備!\r\n#r#e請從下面的列表中挑選武器#n\r\n\r\n#b";
		selStr += "#fUI/UIWindow2.img/QuestIcon/3/0#\r\n";
		for (i = 0; i < wList.length; i++) {
			selStr += "#L" + i + "##i" + wList[i] + ":# #t" + wList[i] + ":##l\r\n";
		}
		cm.sendSimpleS(selStr, 4, 2007);
	} else if (St == 1) {
		if (S == 999 || S == 1212000) {
			cm.dispose();
			return;
		}
		if (cm.getPlayer().getKeyValue(1912211, "timerf") == -1 && cm.getPlayer().getLevel() <= 20) {
			cm.sendOkS("#b#h ##k恭喜, 成功領取下列裝備!\r\n\r\n#b"
				+ "#fUI/UIWindow2.img/QuestIcon/4/0#\r\n"
				+ "  #i" + wList[S] + ":# #t" + wList[S] + ":#\r\n", 4, 2007);
				+ "  #i1003863:# #t1003863:#\r\n"
				+ "  #i1052612:# #t1052612:#\r\n"
				+ "  #i1102562:# #t1102562:#\r\n"
				+ "  #i1012376:# #t1012376:#\r\n"
				+ "  #i1122252:# #t1122252:#\r\n"
				+ "  #i1132228:# #t1132228:#\r\n"
		addOption(1003863, false);
		addOption(1052612, false);
		addOption(1102562, false);
		addOption(1012376, false);
		addOption(1122252, false);
		addOption(1132228, false);
		addOption(wList[S], true);
		cm.gainItem(2433444, -1);
		if (isBow(wList[S])) {
			cm.gainItem(2060008, 9999);
		}
		if (isCrossbow(wList[S])) {
			cm.gainItem(2061006, 9999);
		}
		if (isGun(wList[S])) {
			cm.gainItem(2330001, 9999);
		}
		cm.dispose();
	}
}

function isGun(itemId) {
	switch (itemId) {
		case 1492181:
		case 1532100:
			return true;

		default:
			return false;
	}
}

function isBow(itemId) {
	switch (itemId) {
		case 1452207:
		case 1592030:
		case 1214020:
			return true;

		default:
			return false;
	}
}

function isCrossbow(itemId) {
	switch (itemId) {
		case 1462195:
		case 1522096:
		case 1214020:
			return true;

		default:
			return false;
	}
}

function isMagician(i) {
	switch (Math.floor(i / 100)) {
		case 2:
		case 12:
		case 22:
		case 27:
		case 32:
		case 142:
		case 152:
			return true;

		default:
			return false;
	}
}

function getWeapon(i) {
	switch (Math.floor(cm.getPlayer().getJob() / 10)) {
		/* 전사 */
		case 10:
			wList.push(1302277); // 한손검
			wList.push(1312155); // 한손도끼
			wList.push(1322205); // 한손둔기
			wList.push(1402199); // 두손검
			wList.push(1412137); // 두손도끼
			wList.push(1422142); // 두손둔기
			wList.push(1432169); // 창
			wList.push(1442225); // 폴암
			break;

		case 11:
			wList.push(1302277); // 한손검
			wList.push(1402199); // 두손검
			break;

		case 12:
			wList.push(1302277); // 한손검
			wList.push(1312155); // 한손도끼
			wList.push(1322205); // 한손둔기
			wList.push(1402199); // 두손검

			wList.push(1412137); // 두손도끼
			wList.push(1422142); // 두손둔기
			break;

		case 13:
			wList.push(1432169); // 창
			wList.push(1442225); // 폴암
			break;

		case 110:
		case 111:
			wList.push(1402199); // 두손검
			break;

		case 210:
		case 211:
			wList.push(1442225); // 폴암
			break;

		case 310:
			wList.push(1312155); // 한손도끼
			wList.push(1322205); // 한손둔기
			wList.push(1232060); // 데스페라도
			break;

		case 311:
			wList.push(1312155); // 한손도끼
			wList.push(1322205); // 한손둔기
			break;

		case 312:
			wList.push(1232060); // 데스페라도
			break;

		case 370:
		case 371:
			wList.push(1582039); // 건틀렛 리볼버
			break;

		case 510:
		case 511: //미하일
			wList.push(1302277); // 한손검
			break;

		case 610:
		case 611:
			wList.push(1402199); // 두손검
			break;

		case 1510:
		case 1511:
			wList.push(1213020); // 튜너
			break;

		/* 마법사 */
		case 20:
		case 21:
		case 22:
		case 23:
		case 120:
		case 121:
		case 220:
		case 221:
		case 1620:
			wList.push(1372179); // 완드
			wList.push(1382211); // 스태프
			break;

		case 270:
		case 271:
			wList.push(1212066); // 샤이닝로드
			break;

		case 320:
		case 321:
			wList.push(1382211); // 스태프
			break;

		case 1420:
		case 1421:
			wList.push(1262047); // ESP 리미터
			break;

		case 1520:
		case 1521:
			wList.push(1282019); // 매직 건틀렛
			break;

		/* 궁1수 */
		case 30:
		case 6300:
			wList.push(1452207); // 활
			wList.push(1462195); // 석궁
			wList.push(1592030); // 에인션트 보우
			wList.push(1214020); //브레드 슈터
			break;

		case 630:
		case 6010:
		case 6300:
			wList.push(1214020); // 브레드 슈터
			break;

		case 31:
		case 130:
		case 131:
			wList.push(1452207); // 활
			break;

		case 32:
		case 330:
		case 331:
			wList.push(1462195); // 석궁
			break;


		case 33:
			wList.push(1592030); // 에인션트 보우
			break;

		case 230:
		case 231:
			wList.push(1522096); // 듀얼 보우건
			break;

		case 40:
			wList.push(1332227); // 단검
			wList.push(1472216); // 아대
			break;

		case 41:
		case 140:
		case 141:
			wList.push(1472216); // 아대
			break;

		case 42:
		case 43:
			wList.push(1332227); // 단검
			break;

		case 240:
		case 241:
			wList.push(1362092); // 케인
			break;

		case 360:
		case 361:
			wList.push(1242065); // 에너지소드
			break;

		case 640:
		case 641:
			wList.push(1272019); // 체인
			break;

		case 1640:
		case 1641:
			wList.push(1292020); // 부채
			break;

		//해적
		case 50:
			wList.push(1482170); // 너클
			wList.push(1492181); // 건
			wList.push(1532100); // 핸드캐논
			break;

		case 51:
		case 150:
		case 151:
		case 250:
		case 251:
		case 1550:
		case 1551:
			wList.push(1482170); // 너클
			break;

		case 52:
		case 350:
		case 351:
			wList.push(1492181); // 건
			break;

		case 53:
			wList.push(1532100); // 핸드캐논
			break;

		case 650:
		case 651:
			wList.push(1222061); // 소울슈터
			break;


		case 1011:
			break;

		default:
			wList.push(1212000);
			break;
	}
}
function hpJobCheck(job) {
	return [3101, 3120, 3121, 3122].indexOf(job) !== -1;
}

function addOption(i, isWeapon) {
	item = Packages.server.MapleItemInformationProvider.getInstance().generateEquipById(i, -1);
	if (!isWeapon) {
		if (hpJobCheck(cm.getPlayer().getJob())) {
			item.setEnchantHp(item.getEnchantHp() + 2500);
			item.setPotentialLevel(19);
			item.setPotential1(20045);
			item.setPotential2(20045);
			item.setPotential3(20045);
		}
		else {
			item.setEnchantStr(item.getEnchantStr() + 50);
			item.setEnchantDex(item.getEnchantDex() + 50);
			item.setEnchantInt(item.getEnchantInt() + 50);
			item.setEnchantLuk(item.getEnchantLuk() + 50);
			item.setPotentialLevel(19);
			item.setPotential1(20086);
			item.setPotential2(20086);
			item.setPotential3(20086);
		}
	}
	else {
		item.setEnchantDamage(10);
		if (hpJobCheck(cm.getPlayer().getJob())) {
			item.setEnchantHp(item.getEnchantHp() + 5000);
			item.setEnchantWatk(item.getEnchantWatk() + 100);
			item.setPotentialLevel(19);
			item.setPotential1(20045);
			item.setPotential2(20045);
			item.setPotential3(20045);
		}
		else {
			item.setEnchantStr(item.getEnchantStr() + 100);
			item.setEnchantDex(item.getEnchantDex() + 100);
			item.setEnchantInt(item.getEnchantInt() + 100);
			item.setEnchantLuk(item.getEnchantLuk() + 100);
			item.setPotentialLevel(19);
			if (isMagician(cm.getPlayer().getJob())) {
				item.setEnchantMatk(item.getEnchantMatk() + 100);
			}
			else {
				item.setEnchantWatk(item.getEnchantWatk() + 100);
			}

			item.setPotential1(20086);
			item.setPotential2(20086);
			item.setPotential3(20086);
		}
	}
	item.setEnchantReductReqLevel(90);
	item.setEnchantLevel(item.getTemplate().getUpgradeSlots());
	item.setSuccessUpgradeSlots(item.getTemplate().getUpgradeSlots());
	item.setStarForceLevel(8)
	item.calcStarForceStats();
	// item.setExpiration(System.currentTimeMillis() + (7 * 24 * 3600 * 1000));
	Packages.server.MapleInventoryManipulator.addbyItem(cm.getClient(), item, false);
}