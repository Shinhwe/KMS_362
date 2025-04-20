/*

     [ PlatinumMS ]

     이 스크립트는 PlatinumMS 에서 제작한 스크립트 입니다.

     스크립트 용도 : 70레벨 장비상자

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
                case 111:
                case 121:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040184, 1);
                        cm.gainItem(1060172, 1);
                    } else {
                        cm.gainItem(1041187, 1);
                        cm.gainItem(1061196, 1);

                    }
                    cm.gainItem(1003341, 1);
                    cm.gainItem(1072604, 1);
                    cm.gainItem(1082386, 1); 
                    cm.gainItem(1092104, 1);
                    
                    cm.gainItem(1302191, 1);
                    break;
                case 131:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040182, 1);
                        cm.gainItem(1060170, 1);
                    } else {
                        cm.gainItem(1041185, 1);
                        cm.gainItem(1061194, 1);

                    }
                    cm.gainItem(1003336, 1);
                    cm.gainItem(1072599, 1);
                    cm.gainItem(1082381, 1); 
                    cm.gainItem(1092103, 1);
                    
                    cm.gainItem(1432115, 1);
                    break;
                case 1111:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040184, 1);
                        cm.gainItem(1060172, 1);
                    } else {
                        cm.gainItem(1041187, 1);
                        cm.gainItem(1061196, 1);

                    }
                    cm.gainItem(1003341, 1);
                    cm.gainItem(1072604, 1);
                    cm.gainItem(1082386, 1); 
                    cm.gainItem(1092104, 1);
                    
                    cm.gainItem(1302191, 1);
                    break;
                case 2111:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040182, 1);
                        cm.gainItem(1060170, 1);
                    } else {
                        cm.gainItem(1041185, 1);
                        cm.gainItem(1061194, 1);

                    }
                    cm.gainItem(1003336, 1);
                    cm.gainItem(1072599, 1);
                    cm.gainItem(1082381, 1); 
                    cm.gainItem(1092103, 1);
                    
                    cm.gainItem(1442153, 1);
                    break;
                case 3111:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040182, 1);
                        cm.gainItem(1060170, 1);
                    } else {
                        cm.gainItem(1041185, 1);
                        cm.gainItem(1061194, 1);

                    }
                    cm.gainItem(1003336, 1);
                    cm.gainItem(1072599, 1);
                    cm.gainItem(1082381, 1); 
                    cm.gainItem(1092103, 1);
                    
                    cm.gainItem(1322121, 1);
                    break;
                 case 3121:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040182, 1);
                        cm.gainItem(1060170, 1);
                    } else {
                        cm.gainItem(1041185, 1);
                        cm.gainItem(1061194, 1);

                    }
                    cm.gainItem(1003336, 1);
                    cm.gainItem(1072599, 1);
                    cm.gainItem(1082381, 1); 
                    cm.gainItem(1092103, 1);
                    
                    cm.gainItem(1232005, 1);
                    break;
                case 5111:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040184, 1);
                        cm.gainItem(1060172, 1);
                    } else {
                        cm.gainItem(1041187, 1);
                        cm.gainItem(1061196, 1);

                    }
                    cm.gainItem(1003341, 1);
                    cm.gainItem(1072604, 1);
                    cm.gainItem(1082386, 1); 
                    cm.gainItem(1092104, 1);
                    
                    cm.gainItem(1302191, 1);
                    break;
                case 211:
                case 221:
                case 231:
                case 1211:
                case 2214:
                case 3211:
                    if (cm.getPlayer().getGender() == 0) {
                        //cm.gainItem(1050205, 1);
//                        cm.gainItem(1060156, 1);
                    } else {
                        //cm.gainItem(1051249, 1);
//                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1003342, 1);
                    cm.gainItem(1072605, 1);
                    cm.gainItem(1082387, 1);
                    //cm.gainItem(1372116, 1);
                    break;
                case 311:
                case 1311:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050206, 1);
                        //cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1051250, 1);
                        //cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003343, 1);
                    cm.gainItem(1072606, 1);
                    cm.gainItem(1082388, 1);
                    cm.gainItem(1452146, 1);
                    break;
                case 321:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050206, 1);
                        //cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1051250, 1);
                        //cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003343, 1);
                    cm.gainItem(1072606, 1);
                    cm.gainItem(1082388, 1);
                    cm.gainItem(1462135, 1);
                    break;
                case 2311:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050206, 1);
                        //cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1051250, 1);
                        //cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003343, 1);
                    cm.gainItem(1072606, 1);
                    cm.gainItem(1082388, 1);
                    cm.gainItem(1522037, 1);
                    cm.gainItem(1352007, 1);
                    break;
                case 3311:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050206, 1);
                        //cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1051250, 1);
                        //cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003343, 1);
                    cm.gainItem(1072606, 1);
                    cm.gainItem(1082388, 1);
                    cm.gainItem(1462135, 1);
                    break;
                case 411:
                case 421:
                case 1411:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040185, 1);
                        cm.gainItem(1060173, 1);
                    } else {
                        cm.gainItem(1041188, 1);
                        cm.gainItem(1061197, 1);
                    }
                    cm.gainItem(1003344, 1);
                    cm.gainItem(1072607, 1);
                    cm.gainItem(1082389, 1);
                    
                    cm.gainItem(1472121, 1);
                    cm.gainItem(1332167, 1);
                    break;
                case 3611:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040185, 1);
                        cm.gainItem(1060173, 1);
                    } else {
                        cm.gainItem(1041188, 1);
                        cm.gainItem(1061197, 1);
                    }
                    cm.gainItem(1003344, 1);
                    cm.gainItem(1072607, 1);
                    cm.gainItem(1082389, 1);
                    
                    cm.gainItem(1242005, 1);
                    break;
                    
                case 433:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040185, 1);
                        cm.gainItem(1060173, 1);
                    } else {
                        cm.gainItem(1041188, 1);
                        cm.gainItem(1061197, 1);
                    }
                    cm.gainItem(1003344, 1);
                    cm.gainItem(1072607, 1);
                    cm.gainItem(1082389, 1);
                    
                    cm.gainItem(1332167, 1);
                    cm.gainItem(1342052, 1);
                    
                    break;
                case 2411:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040185, 1);
                        cm.gainItem(1060173, 1);
                    } else {
                        cm.gainItem(1041188, 1);
                        cm.gainItem(1061197, 1);
                    }
                    cm.gainItem(1003344, 1);
                    cm.gainItem(1072607, 1);
                    cm.gainItem(1082389, 1);
                    
                    cm.gainItem(1362055, 1);
                    cm.gainItem(1352107, 1);
                    break;
                case 511:
                case 521:
                case 1511:
		case 2511:
                    cm.gainItem(1003345, 1);
                    cm.gainItem(1052398, 1);
                    cm.gainItem(1072608, 1);
                    cm.gainItem(1082390, 1);
                    cm.gainItem(1482119, 1);
                    cm.gainItem(1492118, 1);
                    break;
                case 3511:
                    cm.gainItem(1003345, 1);
                    cm.gainItem(1052398, 1);
                    cm.gainItem(1072608, 1);
                    cm.gainItem(1082390, 1);
                    cm.gainItem(1492118, 1);
                    break;
                case 531:
                    cm.gainItem(1003345, 1);
                    cm.gainItem(1052398, 1);
                    cm.gainItem(1072608, 1);
                    cm.gainItem(1082390, 1);
                    cm.gainItem(1482119, 1);
                    cm.gainItem(1532054, 1);
                    break;
                case 6111:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040184, 1);
                        cm.gainItem(1060172, 1);
                    } else {
                        cm.gainItem(1041187, 1);
                        cm.gainItem(1061196, 1);

                    }
                    cm.gainItem(1003341, 1);
                    cm.gainItem(1072604, 1);
                    cm.gainItem(1082386, 1); 
                    cm.gainItem(1402012, 1);
                    break;
                case 6511:
                    cm.gainItem(1003345, 1);
                    cm.gainItem(1052398, 1);
                    cm.gainItem(1072608, 1);
                    cm.gainItem(1082390, 1);
                    cm.gainItem(1222039, 1);
		    break;
                case 2711:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050205, 1);
                        cm.gainItem(1060156, 1);
                    } else {
                        cm.gainItem(1051249, 1);
                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1003342, 1);
                    cm.gainItem(1072605, 1);
                    cm.gainItem(1082387, 1);
                    cm.gainItem(1212039, 1);
                    break;
                default:
                    cm.sendOk("장비를 지급받을 수 있는 직업단계가 아닙니다. 전직이 가능한 레벨인 경우, 전직을 하신 후 장비를 받을 수 있습니다.");
                    cm.dispose();
                    return;
                    
            }
	    cm.gainItem(2430452,-1);
	    cm.dispose();
        }
    }
}
