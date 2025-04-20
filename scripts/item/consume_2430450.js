/*

     [ PlatinumMS ]

     이 스크립트는 PlatinumMS 에서 제작한 스크립트 입니다.

     스크립트 용도 : 50레벨 장비상자

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
                        cm.gainItem(1040180, 1);
                        cm.gainItem(1060168, 1);
                    } else {
                        cm.gainItem(1041183, 1);
                        cm.gainItem(1061192, 1);

                    }
                    cm.gainItem(1003331, 1);
                    cm.gainItem(1072594, 1);
                    cm.gainItem(1082376, 1); 
                    cm.gainItem(1092102, 1);
                    
                    cm.gainItem(1302189, 1);
                    break;
                case 130:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040180, 1);
                        cm.gainItem(1060168, 1);
                    } else {
                        cm.gainItem(1041183, 1);
                        cm.gainItem(1061192, 1);

                    }
                    cm.gainItem(1003331, 1);
                    cm.gainItem(1072594, 1);
                    cm.gainItem(1082376, 1); 
                    cm.gainItem(1092102, 1);
                    
                    cm.gainItem(1432113, 1);
                    break;
                case 1110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040180, 1);
                        cm.gainItem(1060168, 1);
                    } else {
                        cm.gainItem(1041183, 1);
                        cm.gainItem(1061192, 1);

                    }
                    cm.gainItem(1003331, 1);
                    cm.gainItem(1072594, 1);
                    cm.gainItem(1082376, 1); 
                    cm.gainItem(1092102, 1);
                    
                    cm.gainItem(1302189, 1);
                    break;
                case 2110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040180, 1);
                        cm.gainItem(1060168, 1);
                    } else {
                        cm.gainItem(1041183, 1);
                        cm.gainItem(1061192, 1);

                    }
                    cm.gainItem(1003331, 1);
                    cm.gainItem(1072594, 1);
                    cm.gainItem(1082376, 1); 
                    cm.gainItem(1092102, 1);
                    
                    cm.gainItem(1442151, 1);
                    break;
                case 3110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040180, 1);
                        cm.gainItem(1060168, 1);
                    } else {
                        cm.gainItem(1041183, 1);
                        cm.gainItem(1061192, 1);

                    }
                    cm.gainItem(1003331, 1);
                    cm.gainItem(1072594, 1);
                    cm.gainItem(1082376, 1); 
                    cm.gainItem(1092102, 1);
                    
                    cm.gainItem(1322119, 1);
                    break;
                 case 3121:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040180, 1);
                        cm.gainItem(1060168, 1);
                    } else {
                        cm.gainItem(1041183, 1);
                        cm.gainItem(1061192, 1);

                    }
                    cm.gainItem(1003331, 1);
                    cm.gainItem(1072594, 1);
                    cm.gainItem(1082376, 1); 
                    cm.gainItem(1092102, 1);
                    
                    cm.gainItem(1232003, 1);
                    break;
                case 5110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040180, 1);
                        cm.gainItem(1060168, 1);
                    } else {
                        cm.gainItem(1041183, 1);
                        cm.gainItem(1061192, 1);

                    }
                    cm.gainItem(1003331, 1);
                    cm.gainItem(1072594, 1);
                    cm.gainItem(1082376, 1); 
                    cm.gainItem(1092102, 1);
                    
                    cm.gainItem(1302189, 1);
                    break;
                case 210:
                case 220:
                case 230:
                case 1210:
                case 2213:
                case 3210:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050203, 1);
//                        cm.gainItem(1060156, 1);
                    } else {
                        cm.gainItem(1051247, 1);
//                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1003332, 1);
                    cm.gainItem(1072595, 1);
                    cm.gainItem(1082377, 1);
                    cm.gainItem(1372115, 1);
                    break;
                case 310:
                case 1310:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050202, 1);
                        //cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1051246, 1);
                        //cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003333, 1);
                    cm.gainItem(1072596, 1);
                    cm.gainItem(1082378, 1);
                    cm.gainItem(1452144, 1);
                    break;
                case 320:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050202, 1);
                        //cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1051246, 1);
                        //cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003333, 1);
                    cm.gainItem(1072596, 1);
                    cm.gainItem(1082378, 1);
                    cm.gainItem(1462133, 1);
                    break;
                case 2310:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050202, 1);
                        //cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1051246, 1);
                        //cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003333, 1);
                    cm.gainItem(1072596, 1);
                    cm.gainItem(1082378, 1);
                    cm.gainItem(1522035, 1);
                    break;
                case 3310:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050202, 1);
                        //cm.gainItem(1060166, 1);
                    } else {
                        cm.gainItem(1051246, 1);
                        //cm.gainItem(1061190, 1);
                    }
                    cm.gainItem(1003333, 1);
                    cm.gainItem(1072596, 1);
                    cm.gainItem(1082378, 1);
                    cm.gainItem(1462133, 1);
                    break;
                case 410:
                case 420:
                case 1410:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040181, 1);
                        cm.gainItem(1060169, 1);
                    } else {
                        cm.gainItem(1041184, 1);
                        cm.gainItem(1061193, 1);
                    }
                    cm.gainItem(1003334, 1);
                    cm.gainItem(1072597, 1);
                    cm.gainItem(1082379, 1);
                    
                    cm.gainItem(1472156, 1);
                    cm.gainItem(1332165, 1);
                    break;
                case 3610:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040181, 1);
                        cm.gainItem(1060169, 1);
                    } else {
                        cm.gainItem(1041184, 1);
                        cm.gainItem(1061193, 1);
                    }
                    cm.gainItem(1003334, 1);
                    cm.gainItem(1072597, 1);
                    cm.gainItem(1082379, 1);
                   
                    cm.gainItem(1242003, 1);
                    break;
                    
                case 431:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040181, 1);
                        cm.gainItem(1060169, 1);
                    } else {
                        cm.gainItem(1041184, 1);
                        cm.gainItem(1061193, 1);
                    }
                    cm.gainItem(1003334, 1);
                    cm.gainItem(1072597, 1);
                    cm.gainItem(1082379, 1);
                    
                    cm.gainItem(1332165, 1);
                    cm.gainItem(1342050, 1);
                    
                    break;
                case 2410:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040181, 1);
                        cm.gainItem(1060169, 1);
                    } else {
                        cm.gainItem(1041184, 1);
                        cm.gainItem(1061193, 1);
                    }
                    cm.gainItem(1003334, 1);
                    cm.gainItem(1072597, 1);
                    cm.gainItem(1082379, 1);
                    
                    cm.gainItem(1362053, 1);
                    break;
                case 510:
                case 520:
                case 1510:
		case 2510:
                    cm.gainItem(1003335, 1);
                    cm.gainItem(1052396, 1);
                    cm.gainItem(1072598, 1);
                    cm.gainItem(1082380, 1);
                    cm.gainItem(1482117, 1);
                    cm.gainItem(1492116, 1);
                    break;
                case 3510:
                    cm.gainItem(1003335, 1);
                    cm.gainItem(1052396, 1);
                    cm.gainItem(1072598, 1);
                    cm.gainItem(1082380, 1);
                    cm.gainItem(1492116, 1);
                    break;
                case 530:
                    cm.gainItem(1003335, 1);
                    cm.gainItem(1052396, 1);
                    cm.gainItem(1072598, 1);
                    cm.gainItem(1082380, 1);
                    cm.gainItem(1532052, 1);
                    break;
                case 6110:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1040180, 1);
                        cm.gainItem(1060168, 1);
                    } else {
                        cm.gainItem(1041183, 1);
                        cm.gainItem(1061192, 1);

                    }
                    cm.gainItem(1003331, 1);
                    cm.gainItem(1072594, 1);
                    cm.gainItem(1082376, 1); 
                    cm.gainItem(1402003, 1);
                    break;
                case 6510:
                    cm.gainItem(1003335, 1);
                    cm.gainItem(1052396, 1);
                    cm.gainItem(1072598, 1);
                    cm.gainItem(1082380, 1);
                    cm.gainItem(1222003, 1);
		    break;
                case 2710:
                    if (cm.getPlayer().getGender() == 0) {
                        cm.gainItem(1050203, 1);
                        cm.gainItem(1060156, 1);
                    } else {
                        cm.gainItem(1051247, 1);
                        cm.gainItem(1061184, 1);
                    }
                    cm.gainItem(1003332, 1);
                    cm.gainItem(1072595, 1);
                    cm.gainItem(1082377, 1);
                    cm.gainItem(1212037, 1);
                    break;
                default:
                    cm.sendOk("장비를 지급받을 수 있는 직업단계가 아닙니다. 전직이 가능한 레벨인 경우, 전직을 하신 후 장비를 받을 수 있습니다.");
                    cm.dispose();
                    return;
                    
            }
	    cm.gainItem(2430450,-1);
	    cm.dispose();
        }
    }
}
