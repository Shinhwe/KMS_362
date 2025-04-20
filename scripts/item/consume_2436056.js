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
        cm.gainItem(2436056, -1);
        ItemInfo = Packages.server.MapleItemInformationProvider.getInstance().getEquipById(1122150);
	ItemInfo.setReqLevel(10);
	ItemInfo.設置潛能等級(20);
        ItemInfo.setStr(100);
	ItemInfo.setDex(100);
	ItemInfo.setInt(100);
	ItemInfo.setLuk(100);
	ItemInfo.setWatk(100);
	ItemInfo.setMatk(100);
	ItemInfo.設置第一條主潛能(40650);
	ItemInfo.設置第二條主潛能(40650);
	ItemInfo.設置第三條主潛能(40650);
        ItemInfo.設置第一條附加潛能(40656);
        ItemInfo.設置第二條附加潛能(40656);
        ItemInfo.設置第三條附加潛能(40656);
	ItemInfo.setExpiration(System.currentTimeMillis() + (30 * 24 * 3600 * 1000));
        MapleInventoryManipulator.addFromDrop(cm.getClient(), ItemInfo, false);
	}
}
