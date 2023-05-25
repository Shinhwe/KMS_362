function start() {
    status = -1;
    action(1, 0, 0);
}

function action(mode, type, selection) {
	// if (cm.getPlayer().isGM()) {
	cm.sendOkS("#b你好, 没有找到当前NPC的脚本.\r\n#dNPC ID : " + cm.getNpc() + " 脚本路径 : " + cm.getScript() + "\r\n#k可以在github提issue, 如果我有空的话, 我会去官服看看这个NPC到底啥作用", 2);
	// } else {
	// cm.sendOkS("#b我跟你无话可说", 4);
	// }
	cm.dispose();
}