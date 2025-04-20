/*

     [ PlatinumMS ]

     이 스크립트는 PlatinumMS 에서 제작한 스크립트 입니다.

     스크립트 용도 : 35레벨 장비상자

*/

importPackage(Packages.client.items);
var status = -1;

function start() {
    status = -1;
    action(1, 1, 0);
}

function action(mode, type, selection) {
    if (mode < 0) {
        cm.dispose();
    return;
    } else {
        if (mode == 1)
            status++;
        else
            status--;
        if (status == 0) {
                   var leftslot = cm.getPlayer().getInventory(MapleInventoryType.EQUIP).getNumFreeSlot();
            if (leftslot < 9) {
                cm.sendOk("인벤토리 공간이 최소한 9칸은 필요합니다. 장비 탭의 공간을 9칸이상 비워주신 후 다시 열어주세요.");
                cm.dispose();
                return;
            }
            
            switch (cm.getPlayer().getJob()) {
                case 110:
                case 120:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050198, 1);
                        //cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1051242, 1);
                        //cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003321, 1);
                    cm.gainItem(1072584, 1);
                    cm.gainItem(1082366, 1); 
                    cm.gainItem(1092100, 1);
                    
                    cm.gainItem(1302187, 1);
                    break;
                case 130:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050198, 1);
                        //cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1051242, 1);
                        //cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003321, 1);
                    cm.gainItem(1072584, 1);
                    cm.gainItem(1082366, 1); 
                    cm.gainItem(1092100, 1);
                    
                    cm.gainItem(1432111, 1);
                    break;
                case 1110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050198, 1);
                        //cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1051242, 1);
                        //cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003321, 1);
                    cm.gainItem(1072584, 1);
                    cm.gainItem(1082366, 1); 
                    cm.gainItem(1092100, 1);
                    
                    cm.gainItem(1302187, 1);
                    break;
                case 2110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050198, 1);
                        //cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1051242, 1);
                        //cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003321, 1);
                    cm.gainItem(1072584, 1);
                    cm.gainItem(1082366, 1); 
                    cm.gainItem(1092100, 1);
                    
                    cm.gainItem(1442149, 1);
                    break;
                case 3110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050198, 1);
                        //cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1051242, 1);
                        //cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003321, 1);
                    cm.gainItem(1072584, 1);
                    cm.gainItem(1082366, 1); 
                    cm.gainItem(1092100, 1);
                    
                    cm.gainItem(1322131, 1);
                    break;
                case 5110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050198, 1);
                        //cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1051242, 1);
                        //cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003321, 1);
                    cm.gainItem(1072584, 1);
                    cm.gainItem(1082366, 1); 
                    cm.gainItem(1092100, 1);
                    
                    cm.gainItem(1302187, 1);
                    break;
                case 210:
                case 220:
                case 230:
                case 1210:
                case 2211:
                case 3210:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050200, 1);
//                        cm.gainItem(1060156, 1);
                    } else {
                        cm.gainItem(1051244, 1);
//                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1003322, 1);
                    cm.gainItem(1072585, 1);
                    cm.gainItem(1082367, 1);
                    cm.gainItem(1382137, 1);
                    break;
                case 310:
                case 1310:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040175, 1);
                        cm.gainItem(1060163, 1);
                    } else {
                        cm.gainItem(1041179, 1);
                        cm.gainItem(1061188, 1);
                    }
                    cm.gainItem(1003323, 1);
                    cm.gainItem(1072586, 1);
                    cm.gainItem(1082368, 1);
                    cm.gainItem(1452142, 1);
                    break;
                case 320:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040175, 1);
                        cm.gainItem(1060163, 1);
                    } else {
                        cm.gainItem(1041179, 1);
                        cm.gainItem(1061188, 1);
                    }
                    cm.gainItem(1003323, 1);
                    cm.gainItem(1072586, 1);
                    cm.gainItem(1082368, 1);
                    cm.gainItem(1462108, 1);
                    break;
                case 2310:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040175, 1);
                        cm.gainItem(1060163, 1);
                    } else {
                        cm.gainItem(1041179, 1);
                        cm.gainItem(1061188, 1);
                    }
                    cm.gainItem(1003323, 1);
                    cm.gainItem(1072586, 1);
                    cm.gainItem(1082368, 1);
                    cm.gainItem(1522033, 1);
                    break;
                case 3310:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040175, 1);
                        cm.gainItem(1060163, 1);
                    } else {
                        cm.gainItem(1041179, 1);
                        cm.gainItem(1061188, 1);
                    }
                    cm.gainItem(1003323, 1);
                    cm.gainItem(1072586, 1);
                    cm.gainItem(1082368, 1);
                    cm.gainItem(1462108, 1);
                    break;
                case 410:
                case 420:
                case 1410:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040176, 1);
                        cm.gainItem(1060164, 1);
                    } else {
                        cm.gainItem(1051243, 1);
                        //cm.gainItem(1061186, 1);
                    }
                    cm.gainItem(1003324, 1);
                    cm.gainItem(1072587, 1);
                    cm.gainItem(1082369, 1);
                    
                    cm.gainItem(1472154, 1);
                    cm.gainItem(1332163, 1);
                    break;
                    
                case 431:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040176, 1);
                        cm.gainItem(1060164, 1);
                    } else {
                        cm.gainItem(1051243, 1);
                        //cm.gainItem(1061186, 1);
                    }
                    cm.gainItem(1003324, 1);
                    cm.gainItem(1072587, 1);
                    cm.gainItem(1082369, 1);
                    
                    cm.gainItem(1332163, 1);
                    //cm.gainItem(1342048, 1);
                    
                    break;
                case 2410:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040176, 1);
                        cm.gainItem(1060164, 1);
                    } else {
                        cm.gainItem(1051243, 1);
                        //cm.gainItem(1061186, 1);
                    }
                    cm.gainItem(1003324, 1);
                    cm.gainItem(1072587, 1);
                    cm.gainItem(1082369, 1);
                    
                    cm.gainItem(1362051, 1);
                    break;
                case 510:
		case 2510:
                case 520:
                case 1510:
                    cm.gainItem(1003325, 1);
                    cm.gainItem(1052394, 1);
                    cm.gainItem(1072588, 1);
                    cm.gainItem(1082370, 1);
                    cm.gainItem(1482115, 1);
                    cm.gainItem(1492114, 1);
                    break;
                case 3510:
                    cm.gainItem(1003325, 1);
                    cm.gainItem(1052394, 1);
                    cm.gainItem(1072588, 1);
                    cm.gainItem(1082370, 1);
                    cm.gainItem(1492114, 1);
                    break;
                case 530:
                    cm.gainItem(1003325, 1);
                    cm.gainItem(1052394, 1);
                    cm.gainItem(1072588, 1);
                    cm.gainItem(1082370, 1);
                    cm.gainItem(1532050, 1);
                    break;
                case 6110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050198, 1);
                        cm.gainItem(1060159, 1);
                    } else {
                        cm.gainItem(1051242, 1);
                        cm.gainItem(1061182, 1);

                    }
                    cm.gainItem(1003321, 1);
                    cm.gainItem(1072584, 1);
                    cm.gainItem(1082366, 1); 
                    cm.gainItem(1402006, 1);
                    break;
                case 6510:
                    cm.gainItem(1003325, 1);
                    cm.gainItem(1052394, 1);
                    cm.gainItem(1072588, 1);
                    cm.gainItem(1082370, 1);
		    break;
                case 2710:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050200, 1);
                        cm.gainItem(1060156, 1);
                    } else {
                        cm.gainItem(1051244, 1);
                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1003322, 1);
                    cm.gainItem(1072585, 1);
                    cm.gainItem(1082367, 1);
                    break;
                default:
                    cm.sendOk("장비를 지급받을 수 있는 직업단계가 아닙니다. 전직이 가능한 레벨인 경우, 전직을 하신 후 장비를 받을 수 있습니다.");
                    cm.dispose();
                    return;
                    
            }
	    cm.gainItem(2430448,-1);
	    cm.dispose();
        }
    }
}
