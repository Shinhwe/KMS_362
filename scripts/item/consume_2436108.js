importPackage(Packages.server);
importPackage(Packages.client.inventory);
importPackage(Packages.constants);
importPackage(java.lang);
importPackage(java.io);
importPackage(Packages.packet.creators);
importPackage(Packages.client.items);
importPackage(Packages.server.items);
importPackage(Packages.launch.world);
importPackage(Packages.main.world);
importPackage(Packages.database);
importPackage(java.lang);
importPackage(Packages.server);
importPackage(Packages.handling.world);
importPackage(Packages.tools.packet);

var enter = "\r\n";
var seld = -1;

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
        cm.dispose();
        cm.gainItem(2436108, -1);
        ItemInfo = Packages.server.MapleItemInformationProvider.getInstance().getEquipById(1112908);
	ItemInfo.setReqLevel(100);
	ItemInfo.setPotentialLevel(20);
        ItemInfo.setStr(500);
	ItemInfo.setDex(500);
	ItemInfo.setInt(500);
	ItemInfo.setLuk(500);
	ItemInfo.setWatk(500);
	ItemInfo.setMatk(500);
	ItemInfo.setPotential1(40656);
	ItemInfo.setPotential2(40656);
	ItemInfo.setPotential3(40656);
        ItemInfo.setPotential4(40656);
        ItemInfo.setPotential5(40656);
        ItemInfo.setPotential6(40656);
	ItemInfo.setExpiration(System.currentTimeMillis() + (5 * 24 * 3600 * 1000));
        MapleInventoryManipulator.addFromDrop(cm.getClient(), ItemInfo, false);
	}
}