﻿importPackage(Packages.database);

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
		var msg = "#fs14#각종 랭킹을 확인할 수 있는 게시판입니다.#b"+enter+enter;
		msg += cm.getPlayer().getKeyValue(3, "dojo")+"/"+cm.getPlayer().getKeyValue(3, "dojo_time");
		//msg += "#L1# 레벨 랭킹"+enter;
		//msg += "#L6# 보스헌터 랭킹"+enter;
		//msg += "#L2# 메소 랭킹"+enter;
		//msg += "#L3# 인기도 랭킹"+enter;
		//msg += "#L4# 길드 랭킹"+enter;
		msg += "#L5# 무릉도장 랭킹"+enter;
		//msg += "#L7# PVP 대결 랭킹"+enter;
		cm.sendSimple(msg);
	} else if (status == 1) {
		switch (sel) {
			case 1:
			cm.dispose();
			cm.openNpc(2093000);
			break;
			case 2:
				cm.dispose();
			cm.openNpc(2094000);
			break;
			case 3:
				cm.sendOk(getRank("SELECT * FROM characters WHERE `fame` > 0 AND `gm` = 0 ORDER BY `fame` DESC LIMIT ", "fame", "인기도", 10));
				cm.dispose();
			break;
			case 4:
				cm.sendOk(getRank("SELECT * FROM guilds WHERE `GP` > 0 ORDER BY `GP` DESC LIMIT ", "GP", "보유 GP", 10));
				cm.dispose();
			break;
			case 5:
cm.SaveDojoRank(cm.getPlayer());
				cm.ShowDojoRank();
				cm.dispose();
			break;
			case 6:
				cm.sendOk(getRank("SELECT * FROM characters WHERE `basebpoint` > 0 AND `gm` = 0 ORDER BY `basebpoint` DESC LIMIT ", "basebpoint", "누적포인트", 10));
				cm.dispose();
			break;
		        case 7:
				cm.sendOk(getRank3("SELECT * FROM characters WHERE `willPVPCount` > 0 AND `gm` = 0 ORDER BY `willPVPCount` DESC LIMIT ", "willPVPCount", "WIN", 10, "faillPVPCount"));
				cm.dispose();
			break;
		}
	}
}

function getRank(v1, v2, v3, v4) {
	var ret = "#fs14#랭킹은 최대 #r"+v4+"명#k 까지만 보여집니다.\r\n\r\n";
	var as = 0;
            var names = [];

            var con = DatabaseConnection.getConnection();
            var ps = con.prepareStatement(v1+v4);
            var rs = ps.executeQuery();

            while (rs.next()) {
	as += 1;
                ret += as + ". #b"+rs.getString("name")+"#k "+v3+" : #d" + rs.getInt(v2) + "#k\r\n";
            }
            rs.close();
            ps.close();

        	if (ret.equals("")) return "랭킹이 없습니다.";
        	return ret;
}



function getRank3(v1, v2, v3, v4, v5) {
	var ret = "#fs14#랭킹은 최대 #r"+v4+"명#k 까지만 보여집니다.\r\n\r\n";
	var as = 0;
            var names = [];

            var con = DatabaseConnection.getConnection();
            var ps = con.prepareStatement(v1+v4);
            var rs = ps.executeQuery();

            while (rs.next()) {
	as += 1;
                ret += as + ". #b"+rs.getString("name")+"#k "+v3+" : #d" + rs.getInt(v2) + " / #kLOSE :#d " + rs.getInt(v5) + " #k\\r\n";
            }
            rs.close();
            ps.close();

        	if (ret.equals("")) return "랭킹이 없습니다.";
        	return ret;
}


function getRank2(v1, v2, v3, v4) {
	var ret = "#e랭킹은 최대 "+v4+"명까지만 보여집니다.\r\n";
	var as = 0;
            var names = [];

            var con = DatabaseConnection.getConnection();
            var ps = con.prepareStatement(v1+v4);
            var rs = ps.executeQuery();

            while (rs.next()) {
	as += 1;
                ret += as + ". #b"+rs.getString("name")+"#k "+v3+" : #d" + rs.getLong(v2) + "#k\r\n";
            }
            rs.close();
            ps.close();

        	if (ret.equals("")) return "랭킹이 없습니다.";
        	return ret;
}
