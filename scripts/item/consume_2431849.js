﻿importPackage(java.lang);
importPackage(java.io);

var ck = 0;

function start()
{
	St = -1;
	action(1, 0, 0);
}

function action(M, T, S)
{
	if(M != 1)
	{
		cm.dispose();
		return;
	}

	if(M == 1)
	St++;

	if(St == 0)
	{
		item = Packages.server.MapleItemInformationProvider.getInstance().getEquipById(1342104);
		item.setUpgradeSlots(10);
item.setStr(300);
item.setDex(300);
item.setInt(300);
item.setLuk(300);
//item.setHp(10);
//item.setMp(10);
item.setWatk(30000);
item.setMatk(30000);
item.setWdef(0);
item.setSpeed(10);
item.setJump(10);
item.setViciousHammer(10);
item.設置潛能等級(20);
item.設置第一條主潛能(40603);
item.設置第二條主潛能(40603);
item.設置第三條主潛能(40603);
item.設置第一條附加潛能(40603);
item.設置第二條附加潛能(40603);
item.設置第三條附加潛能(40603);
item.setStarForceLevel(10);
//item.setEquipmentType(5888);
item.setBossDamage(100);
item.setIgnorePDR(100);
item.setTotalDamage(100);
item.setAllStat(100);
item.setKarmaCount(10);
//item.setMoru(3022);
//item.setFire(0);
/*item.setSoulName(89);
item.setSoulEnchanter(9);
item.setSoulPotential(404);
item.setSoulSkill(80001270);*/
/*item.setArcLevel(20);
item.setArc(200);
item.setArcEXP(20);*/

		Packages.server.MapleInventoryManipulator.addbyItem(cm.getClient(), item, false, true);
		cm.dispose();
	}
}
