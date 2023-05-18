﻿importPackage(Packages.tools);
importPackage(Packages.server);
importPackage(Packages.tools.packet);
importPackage(Packages.server.life);
importPackage(Packages.constants);
importPackage(Packages.tools.packet);
importPackage(Packages.tools.packet);
importPackage(Packages.constants.programs);
importPackage(Packages.database);
importPackage(java.lang);
importPackage(Packages.handling.world)
importPackage(java.sql);
importPackage(java.util);
importPackage(java.lang);
importPackage(java.io);
importPackage(java.awt);
importPackage(Packages.database);
importPackage(Packages.constants);
importPackage(Packages.client.items);
importPackage(Packages.client.inventory);
importPackage(Packages.server.items);
importPackage(Packages.server);
importPackage(Packages.tools);
importPackage(Packages.server.life);
importPackage(Packages.packet.creators);
importPackage(Packages.client.items);
importPackage(Packages.server.items);
importPackage(Packages.launch.world);
importPackage(Packages.main.world);
importPackage(Packages.database.hikari);
importPackage(java.lang);
importPackage(Packages.handling.world)


var Accessory = [1012029, 1012038, 1012041, 1012042, 1012043, 1012049, 1012051, 1012057, 1012081, 1012090, 1012099, 1012100, 1012112, 1012113, 1012114, 1012121, 1012122, 1012123, 1012124, 1012125, 1012126, 1012127, 1012128, 1012129, 1012131, 1012133, 1012134, 1012147, 1012159, 1012166, 1012179, 1012180, 1012208, 1012253, 1012275, 1012298, 1012315, 1012390, 1012413, 1012462, 1012474, 1012486, 1012487, 1012488, 1012509, 1012510, 1012511, 1012534, 1012552, 1012572, 1012603, 1012609, 1012619, 1012623, 1012628, 1012629, 1012630, 1012635, 1012642, 1012644, 1012645, 1012654, 1012657, 1012662, 1012663, 1012674, 1012677, 1012678, 1012679, 1012680, 1012681, 1012682, 1012685, 1012686, 1012687, 1012690, 1012691, 1012692, 1012695, 1012696, 1012697, 1012698, 1012699, 1012701, 1012706, 1012710, 1012711, 1012712, 1012713, 1012714, 1012715, 1012717, 1012722, 1012731, 1012735, 1012736, 1012737, 1012738, 1012739, 1022046, 1022047, 1022048, 1022057, 1022065, 1022066, 1022081, 1022084, 1022085, 1022087, 1022090, 1022095, 1022104, 1022121, 1022122, 1022173, 1022194, 1022201, 1022207, 1022227, 1022249, 1022250, 1022257, 1022258, 1022266, 1022269, 1022270, 1022275, 1022283, 1022284, 1022286, 1022297, 1032071, 1032072, 1032073, 1032074, 1032138, 1032145, 1032175, 1032204, 1032233, 1032234, 1032255, 1032260, 1032262, 1032264, 1032320, 1032321, 1033000];

var Cap = [1000024, 1000027, 1000028, 1000043, 1000045, 1000046, 1000061, 1000071, 1000081, 1000084, 1000087, 1000099, 1000100, 1000103, 1000104, 1001034, 1001039, 1001040, 1001041, 1001058, 1001061, 1001069, 1001088, 1001094, 1001105, 1001108, 1001122, 1001123, 1001126, 1001127, 1002469, 1002470, 1002472, 1002489, 1002490, 1002542, 1002543, 1002544, 1002545, 1002548, 1002549, 1002555, 1002565, 1002567, 1002570, 1002582, 1002583, 1002593, 1002594, 1002596, 1002605, 1002609, 1002653, 1002654, 1002672, 1002673, 1002674, 1002678, 1002679, 1002692, 1002693, 1002694, 1002695, 1002696, 1002697, 1002700, 1002701, 1002703, 1002704, 1002705, 1002706, 1002725, 1002726, 1002727, 1002734, 1002741, 1002742, 1002752, 1002754, 1002759, 1002760, 1002761, 1002775, 1002811, 1002823, 1002831, 1002834, 1002835, 1002836, 1002837, 1002844, 1002847, 1002876, 1002882, 1002886, 1002887, 1002888, 1002889, 1002890, 1002891, 1002937, 1002941, 1002942, 1002950, 1002951, 1002952, 1002956, 1002957, 1002961, 1002967, 1002968, 1002975, 1002983, 1002984, 1002985, 1002987, 1002998, 1002999, 1003000, 1003001, 1003005, 1003014, 1003015, 1003022, 1003044, 1003047, 1003053, 1003054, 1003059, 1003060, 1003074, 1003079, 1003080, 1003082, 1003101, 1003121, 1003130, 1003144, 1003145, 1003146, 1003148, 1003161, 1003182, 1003185, 1003186, 1003187, 1003202, 1003208, 1003238, 1003241, 1003247, 1003263, 1003272, 1003377, 1003386, 1003387, 1003403, 1003404, 1003417, 1003459, 1003462, 1003463, 1003482, 1003483, 1003484, 1003485, 1003486, 1003487, 1003489, 1003490, 1003504, 1003505, 1003506, 1003508, 1003509, 1003516, 1003517, 1003518, 1003531, 1003532, 1003533, 1003536, 1003559, 1003560, 1003594, 1003626, 1003643, 1003654, 1003655, 1003656, 1003657, 1003658, 1003666, 1003667, 1003670, 1003671, 1003672, 1003673, 1003699, 1003713, 1003730, 1003735, 1003742, 1003743, 1003749, 1003759, 1003760, 1003761, 1003775, 1003790, 1003802, 1003804, 1003815, 1003825, 1003826, 1003827, 1003829, 1003830, 1003843, 1003861, 1003889, 1003897, 1003917, 1003918, 1003919, 1003934, 1003936, 1003948, 1003949, 1003950, 1003962, 1003963, 1003964, 1003975, 1004001, 1004015, 1004016, 1004017, 1004018, 1004024, 1004040, 1004041, 1004042, 1004043, 1004044, 1004045, 1004046, 1004047, 1004073, 1004074, 1004090, 1004091, 1004092, 1004093, 1004094, 1004106, 1004108, 1004110, 1004111, 1004113, 1004122, 1004123, 1004125, 1004126, 1004136, 1004137, 1004157, 1004178, 1004190, 1004191, 1004193, 1004199, 1004200, 1004201, 1004202, 1004203, 1004204, 1004205, 1004251, 1004252, 1004253, 1004282, 1004284, 1004285, 1004295, 1004296, 1004298, 1004299, 1004301, 1004302, 1004303, 1004304, 1004305, 1004306, 1004307, 1004308, 1004309, 1004310, 1004311, 1004312, 1004313, 1004314, 1004315, 1004316, 1004317, 1004318, 1004319, 1004320, 1004321, 1004322, 1004323, 1004324, 1004325, 1004326, 1004332, 1004386, 1004393, 1004394, 1004395, 1004396, 1004397, 1004398, 1004399, 1004400, 1004401, 1004402, 1004406, 1004413, 1004417, 1004418, 1004419, 1004428, 1004438, 1004439, 1004440, 1004448, 1004455, 1004456, 1004461, 1004462, 1004463, 1004471, 1004478, 1004479, 1004482, 1004483, 1004499, 1004500, 1004501, 1004504, 1004505, 1004506, 1004508, 1004515, 1004534, 1004535, 1004536, 1004537, 1004544, 1004545, 1004546, 1004547, 1004548, 1004559, 1004560, 1004561, 1004562, 1004563, 1004570, 1004571, 1004600, 1004601, 1004612, 1004613, 1004614, 1004635, 1004638, 1004639, 1004659, 1004660, 1004661, 1004662, 1004671, 1004672, 1004673, 1004706, 1004708, 1004712, 1004713, 1004720, 1004721, 1004722, 1004733, 1004734, 1004757, 1004758, 1004759, 1004760, 1004762, 1004787, 1004788, 1004790, 1004791, 1004792, 1004799, 1004800, 1004801, 1004802, 1004803, 1004804, 1004805, 1004806, 1004825, 1004826, 1004827, 1004828, 1004829, 1004830, 1004831, 1004832, 1004833, 1004834, 1004835, 1004839, 1004841, 1004843, 1004853, 1004854, 1004858, 1004859, 1004860, 1004862, 1004863, 1004874, 1004876, 1004877, 1004878, 1004879, 1004880, 1004889, 1004890, 1004909, 1004912, 1004916, 1004925, 1004930, 1004932, 1004933, 1004934, 1004936, 1004937, 1004938, 1004940, 1004941, 1004942, 1004945, 1004946, 1004950, 1004951, 1004952, 1004953, 1004961, 1004981, 1004982, 1004983, 1004984, 1004996, 1004997, 1004998, 1005003, 1005004, 1005014, 1005015, 1005016, 1005017, 1005018, 1005019, 1005020, 1005021, 1005022, 1005023, 1005024, 1005025, 1005026, 1005027, 1005045, 1005046, 1005047, 1005048, 1005049, 1005050, 1005060, 1005062, 1005063, 1005064, 1005077, 1005081, 1005082, 1005090, 1005091, 1005095, 1005096, 1005097, 1005098, 1005099, 1005100, 1005101, 1005102, 1005103, 1005114, 1005115, 1005116, 1005117, 1005118, 1005119, 1005120, 1005121, 1005124, 1005131, 1005138, 1005139, 1005140, 1005141, 1005142, 1005149, 1005150, 1005155, 1005156, 1005157, 1005173, 1005174, 1005176, 1005177, 1005178, 1005179, 1005180, 1005181, 1005182, 1005183, 1005190, 1005205, 1005206, 1005207, 1005208, 1005221, 1005222, 1005224, 1005228, 1005236, 1005237, 1005238, 1005239, 1005252, 1005254, 1005255, 1005256, 1005257, 1005258, 1005259, 1005269, 1005270, 1005271, 1005274, 1005275, 1005276, 1005277, 1005278, 1005308, 1005309, 1005310, 1005311, 1005314, 1005316, 1005317, 1005318, 1005322, 1005323, 1005333, 1005334, 1005335, 1005336, 1005337, 1005338, 1005339, 1005340, 1005341, 1005342, 1005352, 1005353, 1005358, 1005363, 1005365, 1005375, 1005378, 1005379, 1005380, 1005381, 1005391, 1005394, 1005395, 1005397, 1005398, 1005401, 1005402, 1005403, 1005404, 1005406, 1005407, 1005408, 1005413, 1005414, 1005415, 1005416, 1005417, 1005418, 1005440, 1005441, 1005442, 1005443, 1005444, 1005445, 1005447, 1005455, 1005456, 1005457, 1005462, 1005463, 1005464, 1005465, 1005466, 1005467, 1005468, 1005469, 1005470, 1005471, 1005472, 1005473, 1005474, 1005475, 1005476, 1005486, 1005487, 1005488, 1005489, 1005490, 1005494, 1005498, 1005503, 1005508, 1005509, 1005510, 1005511, 1005521, 1005522, 1005523, 1005524, 1005525, 1005526, 1005537, 1005538, 1005539, 1005548, 1005549, 1005550, 1005551, 1005559, 1005560, 1005561, 1005562, 1005563, 1005565, 1005576, 1005577, 1005578, 1005581, 1005583, 1005584, 1005585, 1005586, 1005587, 1005588];

var Cape = [1100000, 1102098, 1102144, 1102150, 1102156, 1102162, 1102171, 1102208, 1102209, 1102210, 1102213, 1102214, 1102216, 1102217, 1102218, 1102220, 1102221, 1102229, 1102230, 1102238, 1102240, 1102243, 1102252, 1102253, 1102257, 1102259, 1102291, 1102296, 1102300, 1102301, 1102318, 1102336, 1102343, 1102344, 1102373, 1102374, 1102387, 1102388, 1102391, 1102392, 1102396, 1102419, 1102423, 1102424, 1102425, 1102426, 1102427, 1102428, 1102429, 1102430, 1102431, 1102432, 1102433, 1102434, 1102435, 1102436, 1102437, 1102438, 1102461, 1102465, 1102486, 1102488, 1102508, 1102513, 1102549, 1102555, 1102604, 1102605, 1102613, 1102614, 1102622, 1102631, 1102640, 1102641, 1102642, 1102651, 1102652, 1102653, 1102654, 1102655, 1102656, 1102657, 1102658, 1102668, 1102682, 1102683, 1102684, 1102697, 1102704, 1102705, 1102723, 1102724, 1102726, 1102756, 1102779, 1102780, 1102781, 1102782, 1102783, 1102784, 1102785, 1102786, 1102787, 1102788, 1102798, 1102800, 1102801, 1102808, 1102818, 1102820, 1102827, 1102835, 1102839, 1102842, 1102860, 1102868, 1102884, 1102885, 1102886, 1102908, 1102910, 1102912, 1102913, 1102927, 1102937, 1102938, 1102939, 1102953, 1102954, 1102955, 1102956, 1102957, 1102966, 1102968, 1102969, 1102970, 1102971, 1102972, 1102975, 1102978, 1102982, 1102983, 1102984, 1102991, 1102995, 1103000, 1103002, 1103003, 1103004, 1103007, 1103008, 1103009, 1103026, 1103027, 1103028, 1103032, 1103033, 1103034, 1103037, 1103038, 1103039, 1103040, 1103042, 1103043, 1103044, 1103045, 1103046, 1103047, 1103048, 1103049, 1103058, 1103060, 1103061, 1103066, 1103071, 1103076, 1103077, 1103082, 1103083, 1103084, 1103085, 1103086, 1103092, 1103093, 1103098, 1103099, 1103100, 1103107, 1103108, 1103110, 1103111, 1103112, 1103117, 1103133, 1103139, 1103140, 1103141, 1103147, 1103150, 1103151, 1103154, 1103155, 1103158, 1103159, 1103160, 1103161, 1103162, 1103163, 1103164, 1103169, 1103170, 1103172, 1103173, 1103174, 1103181, 1103182, 1103183, 1103184, 1103189, 1103190, 1103194, 1103195, 1103197, 1103198, 1103199, 1103206, 1103207, 1103214, 1103215, 1103220, 1103225, 1103226, 1103227, 1103228, 1103229, 1103230, 1103231, 1103238, 1103239, 1103245, 1103248, 1103252, 1103253, 1103254, 1103255, 1103258, 1103259, 1103260, 1103265, 1103267, 1103268, 1103269, 1103270, 1103271, 1103272, 1103273, 1103275, 1103276, 1103277, 1103278, 1103279, 1103285, 1103286, 1103297, 1103298, 1103299, 1103307, 1103308, 1103309, 1103310, 1103311, 1103312, 1103316, 1103317, 1103318];

var Coat= [1040139, 1040140, 1040141, 1040143, 1040148, 1040194, 1040195, 1040196, 1041140, 1041143, 1041144, 1041146, 1041147, 1041193, 1041196, 1041197, 1041198, 1042064, 1042065, 1042159, 1042166, 1042171, 1042176, 1042186, 1042187, 1042189, 1042192, 1042208, 1042220, 1042228, 1042229, 1042232, 1042251, 1042252, 1042259, 1042263, 1042266, 1042277, 1042293, 1042311, 1042320, 1042329, 1042332, 1042333, 1042336, 1042338, 1042339, 1042343, 1042345, 1042346, 1042348, 1042350, 1042354, 1042355, 1042356, 1042361, 1042367, 1042375, 1042376, 1042378, 1042382, 1042383, 1042384, 1042385, 1048000, 1048001, 1048002, 1049000, 1102380];

var Glove = [1081006, 1082165, 1082251, 1082253, 1082255, 1082267, 1082274, 1082407, 1082408, 1082421, 1082422, 1082423, 1082448, 1082495, 1082500, 1082502, 1082503, 1082504, 1082511, 1082517, 1082523, 1082541, 1082542, 1082550, 1082554, 1082558, 1082561, 1082563, 1082564, 1082581, 1082585, 1082591, 1082592, 1082623, 1082624, 1082631, 1082641, 1082672, 1082685, 1082689, 1082692, 1082694, 1082702, 1082712, 1082713, 1082714, 1082715, 1082717, 1082718, 1082722, 1082723, 1082726, 1082727, 1082728, 1082731, 1082735, 1082737, 1082738, 1082741, 1082746, 1082747, 1082748, 1082752];

var LongCoat = [1052951, 1052955, 1052956, 1052957, 1052958, 1052959, 1052960, 1052961, 1052965, 1052966, 1052967, 1052997, 1052999, 1053000, 1053001, 1053014, 1053016, 1053017, 1053022, 1053023, 1053024, 1053025, 1053031, 1053032, 1053041, 1053042, 1053045, 1053046, 1053047, 1053048, 1053051, 1053052, 1053053, 1053054, 1053056, 1053057, 1053058, 1053059, 1053060, 1053061, 1053083, 1053084, 1053085, 1053086, 1053087, 1053088, 1053089, 1053090, 1053091, 1053092, 1053093, 1053094, 1053099, 1053103, 1053104, 1053105, 1053106, 1053107, 1053109, 1053110, 1053115, 1053116, 1053117, 1053118, 1053119, 1053124, 1053125, 1053126, 1053127, 1053130, 1053131, 1053132, 1053133, 1053134, 1053138, 1053142, 1053143, 1053144, 1053145, 1053146, 1053148, 1053155, 1053156, 1053157, 1053162, 1053163, 1053164, 1053168, 1053169, 1053170, 1053171, 1053172, 1053173, 1053174, 1053175, 1053176, 1053177, 1053180, 1053183, 1053184, 1053195, 1053196, 1053197, 1053198, 1053199, 1053200, 1053201, 1053202, 1053207, 1053208, 1053209, 1053210, 1053217, 1053218, 1053219, 1053220, 1053221, 1053222, 1053225, 1053226];

var Pants = [1060122, 1060123, 1060125, 1060139, 1060179, 1060181, 1060187, 1060188, 1060189, 1061143, 1061144, 1061145, 1061147, 1061204, 1061207, 1061210, 1061211, 1061212, 1061213, 1062049, 1062050, 1062117, 1062163, 1062170, 1062173, 1062188, 1062189, 1062204, 1062210, 1062211, 1062217, 1062218, 1062220, 1062222, 1062223, 1062228, 1062235, 1062236, 1062244, 1062245, 1062249, 1062250, 1062251];

var Ring = [1112005, 1112006, 1112007, 1112012, 1112013, 1112014, 1112015, 1112016, 1112023, 1112115, 1112127, 1112129, 1112130, 1112131, 1112132, 1112134, 1112136, 1112137, 1112152, 1112157, 1112159, 1112162, 1112163, 1112164, 1112166, 1112171, 1112172, 1112177, 1112179, 1112181, 1112190, 1112193, 1112194, 1112195, 1112196, 1112197, 1112198, 1112199, 1112237, 1112240, 1112244, 1112264, 1112265, 1112269, 1112271, 1112274, 1112275, 1112276, 1112278, 1112283, 1112284, 1112289, 1112291, 1112294, 1112724, 1112728, 1112741, 1112757, 1112808, 1112810, 1112811, 1112812, 1112816, 1112820, 1112909, 1112910, 1112916, 1112917, 1112918, 1112919, 1112929, 1112948, 1112956, 1112958, 1112959, 1112964, 1112965, 1112969, 1112970, 1112971, 1112972, 1112973, 1112974, 1112975, 1112976, 1112977, 1112978, 1113003, 1113171, 1113284, 1113289, 1113298, 1113299, 1114400, 1114401, 1115003, 1115006, 1115007, 1115008, 1115009, 1115010, 1115011, 1115015, 1115022, 1115023, 1115024, 1115025, 1115026, 1115027, 1115029, 1115030, 1115031, 1115032, 1115034, 1115038, 1115039, 1115040, 1115044, 1115046, 1115047, 1115048, 1115050, 1115052, 1115057, 1115058, 1115060, 1115062, 1115066, 1115068, 1115069, 1115071, 1115072, 1115074, 1115075, 1115076, 1115077, 1115078, 1115080, 1115082, 1115084, 1115086, 1115087, 1115090, 1115091, 1115092, 1115093, 1115094, 1115097, 1115098, 1115111, 1115112, 1115113, 1115114, 1115115, 1115116, 1115118, 1115119, 1115120, 1115121, 1115123, 1115127, 1115128, 1115129, 1115133, 1115135, 1115136, 1115137, 1115139, 1115141, 1115146, 1115147, 1115149, 1115151, 1115155, 1115157, 1115158, 1115160, 1115161, 1115163, 1115164, 1115165, 1115166, 1115167, 1115169, 1115171, 1115173, 1115175, 1115176, 1115179, 1115180, 1115193, 1115194, 1115195, 1115198, 1115199, 1115200, 1115202, 1115206, 1115207, 1115209, 1115211, 1115212, 1115216, 1115217, 1115301, 1115303, 1115307, 1115308, 1115310, 1115312, 1115313, 1115317, 1115318];

var Shoes = [1070007, 1070008, 1070014, 1070015, 1070018, 1070031, 1070068, 1070075, 1070115, 1071019, 1071024, 1071025, 1071048, 1071084, 1071092, 1071131, 1072254, 1072255, 1072270, 1072271, 1072277, 1072348, 1072374, 1072380, 1072385, 1072386, 1072387, 1072388, 1072389, 1072392, 1072393, 1072396, 1072397, 1072398, 1072404, 1072405, 1072406, 1072408, 1072410, 1072417, 1072437, 1072439, 1072440, 1072456, 1072464, 1072465, 1072466, 1072467, 1072468, 1072469, 1072470, 1072482, 1072495, 1072507, 1072509, 1072517, 1072520, 1072532, 1072536, 1072537, 1072609, 1072627, 1072628, 1072631, 1072637, 1072647, 1072648, 1072649, 1072650, 1072651, 1072652, 1072658, 1072662, 1072676, 1072680, 1072681, 1072708, 1072729, 1072749, 1072750, 1072770, 1072771, 1072772, 1072773, 1072779, 1072780, 1072781, 1072791, 1072800, 1072807, 1072812, 1072813, 1072820, 1072839, 1072840, 1072848, 1072854, 1072855, 1072863, 1072864, 1072865, 1072869, 1072873, 1072875, 1072878, 1072879, 1072880, 1072881, 1072883, 1072884, 1072909, 1072910, 1072913, 1072916, 1072917, 1072918, 1072919, 1072920, 1072921, 1072922, 1072923, 1072924, 1072925, 1072926, 1072942, 1072944, 1072945, 1072949, 1072950, 1072979, 1072980, 1072999, 1073009, 1073014, 1073022, 1073024, 1073027, 1073036, 1073038, 1073040, 1073046, 1073047, 1073051, 1073052, 1073055, 1073060, 1073061, 1073062, 1073074, 1073080, 1073096, 1073098, 1073106, 1073107, 1073108, 1073129, 1073132, 1073133, 1073134, 1073135, 1073145, 1073150, 1073151, 1073153, 1073154, 1073155, 1073157, 1073167, 1073168, 1073177, 1073178, 1073179, 1073180, 1073181, 1073182, 1073185, 1073188, 1073189, 1073192, 1073195, 1073196, 1073202, 1073203, 1073204, 1073205, 1073215, 1073216, 1073217, 1073222, 1073223, 1073228, 1073229, 1073230, 1073238, 1073239, 1073240, 1073241, 1073242, 1073243, 1073244, 1073247, 1073250, 1073251, 1073253, 1073261, 1073262, 1073263, 1073264, 1073266, 1073267, 1073269, 1073270, 1073274, 1073275, 1073276, 1073283, 1073284, 1073285, 1073286, 1073287, 1073299, 1073303, 1073304, 1073310, 1073312, 1073317, 1073320, 1073321, 1073324, 1073325, 1073326, 1073327, 1073329, 1073330, 1073338, 1073339, 1073347, 1073348, 1073349, 1073354, 1073357, 1073363, 1073370, 1073371, 1073372, 1073373, 1073376, 1073377, 1073379, 1073380, 1073381, 1073382, 1073383, 1073384, 1073385, 1073386, 1073395, 1073396, 1073397, 1073398, 1073399, 1073401, 1073405, 1073406, 1073407, 1073408, 1073409, 1073410, 1073411, 1073412, 1073420, 1073421, 1073427, 1073429, 1073431, 1073435, 1073440, 1073441, 1073442, 1073443, 1073447, 1073452, 1073453, 1073456, 1073460, 1073461, 1073462, 1073464, 1073465, 1073480, 1073481, 1073482, 1073483, 1073495, 1073496, 1073497, 1073511, 1073512, 1073513, 1073514];

var Weapon = [1701000, 1702051, 1702052, 1702053, 1702054, 1702071, 1702075, 1702076, 1702077, 1702089, 1702094, 1702095, 1702097, 1702101, 1702102, 1702104, 1702105, 1702113, 1702116, 1702117, 1702126, 1702128, 1702129, 1702130, 1702131, 1702132, 1702135, 1702138, 1702139, 1702140, 1702143, 1702148, 1702152, 1702153, 1702156, 1702157, 1702161, 1702163, 1702164, 1702171, 1702172, 1702175, 1702178, 1702183, 1702184, 1702185, 1702186, 1702187, 1702189, 1702193, 1702197, 1702198, 1702200, 1702201, 1702204, 1702208, 1702209, 1702210, 1702213, 1702214, 1702215, 1702218, 1702219, 1702220, 1702221, 1702222, 1702223, 1702224, 1702226, 1702228, 1702229, 1702230, 1702231, 1702232, 1702234, 1702235, 1702236, 1702237, 1702239, 1702240, 1702246, 1702249, 1702250, 1702251, 1702252, 1702256, 1702257, 1702258, 1702259, 1702260, 1702261, 1702262, 1702263, 1702264, 1702266, 1702268, 1702274, 1702276, 1702278, 1702279, 1702280, 1702281, 1702282, 1702283, 1702284, 1702285, 1702286, 1702295, 1702296, 1702301, 1702302, 1702303, 1702305, 1702310, 1702311, 1702324, 1702333, 1702335, 1702341, 1702344, 1702345, 1702346, 1702351, 1702355, 1702356, 1702358, 1702359, 1702360, 1702371, 1702372, 1702374, 1702376, 1702379, 1702380, 1702381, 1702392, 1702393, 1702401, 1702402, 1702403, 1702404, 1702407, 1702408, 1702409, 1702417, 1702459, 1702460, 1702462, 1702472, 1702474, 1702475, 1702479, 1702489, 1702491, 1702492, 1702499, 1702506, 1702507, 1702509, 1702510, 1702522, 1702526, 1702556, 1702557, 1702559, 1702560, 1702566, 1702567, 1702572, 1702579, 1702583, 1702585, 1702588, 1702589, 1702600, 1702601, 1702602, 1702603, 1702604, 1702605, 1702606, 1702611, 1702626, 1702630, 1702633, 1702635, 1702636, 1702640, 1702660, 1702671, 1702675, 1702682, 1702684, 1702685, 1702686, 1702692, 1702693, 1702697, 1702698, 1702699, 1702700, 1702710, 1702711, 1702712, 1702713, 1702714, 1702719, 1702722, 1702727, 1702733, 1702740, 1702742, 1702748, 1702750, 1702752, 1702753, 1702758, 1702764, 1702765, 1702773, 1702776, 1702777, 1702778, 1702783, 1702784, 1702785, 1702787, 1702788, 1702789, 1702797, 1702798, 1702799, 1702801, 1702802, 1702803, 1702812, 1702813, 1702814, 1702818, 1702819, 1702820, 1702821, 1702822, 1702825, 1702833, 1702834, 1702840, 1702841, 1702842, 1702846, 1702847, 1702848, 1702853, 1702860, 1702861, 1702862, 1702868, 1702869, 1702873, 1702874, 1702875, 1702878, 1702879, 1702883, 1702884, 1702886, 1702888, 1702890, 1702891, 1702892, 1702894, 1702896, 1702897, 1702898, 1702899, 1702902, 1702903, 1702904, 1702912, 1702913, 1702915, 1702916, 1702917, 1702926, 1702927, 1702930, 1702931, 1702932, 1702933, 1702940, 1702941, 1702947, 1702948, 1702949, 1702954, 1702955, 1702964, 1702965, 1702966, 1702967, 1702968, 1702969, 1702972, 1702978, 1702979, 1702984, 1702985, 1702986, 1702990, 1702991, 1702992, 1702999, 1703000, 1703001, 1703005, 1703006, 1703007, 1703011, 1703012, 1703015, 1703019, 1703020, 1703021, 1703024, 1703025, 1703040, 1703041, 1703042, 1703055, 1703056, 1703057, 1703058, 1703059, 1703064, 1703065, 1703066];

var enter = "\r\n";

//var 로얄 = 0;
//var 스로얄 = 0;
var need = -1, item;
var selected, seld = -1;
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
		var msg = "#fs14#원하는 캐시를 골라봐! 맘에 드는게 많을걸?#k#fs14##b"+enter;
		msg += "#L2#해외캐시를 가지고싶어요"+enter;
		msg += "#L3##r해외 캐시 아이템 리스트를 확인하고 싶습니다.";
		cm.sendSimple(msg);
	} else if (status == 1) {
		seld = sel;
		//need = sel == 1 ? 로얄 : 스로얄;
		if (sel == 3) {
			var msg = "#fs14##r원하는 항목을 선택해#fs14##d"+enter;
			msg += "#L1#악세사리의 리스트"+enter;
			msg += "#L2#모자의 리스트"+enter;
			msg += "#L3#망토의 리스트"+enter;
			msg += "#L4#상의의 리스트"+enter;
			//msg += "#L5#장갑의 리스트"+enter;
			msg += "#L6#한벌옷의 리스트"+enter;
			msg += "#L7#바지의 리스트"+enter;
			//msg += "#L8#말풍선 반지의 리스트"+enter;
			msg += "#L9#신발의 리스트"+enter;
			//msg += "#L10#무기의 리스트"+enter;
			cm.sendSimple(msg);
		} else {
			var msg = "#fs14#원하는 부위를 선택해!#fs14##d"+enter;
			msg += "#L1#악세사리를 뽑고 싶습니다."+enter;
			msg += "#L2#모자를 뽑고 싶습니다."+enter;
			msg += "#L3#망토를 뽑고 싶습니다."+enter;
			msg += "#L4#상의를 뽑고 싶습니다."+enter;
			//msg += "#L5#장갑을 뽑고 싶습니다."+enter;
			msg += "#L6#한벌옷을 뽑고 싶습니다."+enter;
			msg += "#L7#바지를 뽑고 싶습니다."+enter;
			//msg += "#L8#말풍선 반지를 뽑고 싶습니다."+enter;
			msg += "#L9#신발을 뽑고 싶습니다."+enter;
			//msg += "#L10#무기를 뽑고 싶습니다."+enter;
			cm.sendSimple(msg);
		}
	} else if (status == 2) {
		selected = sel == 1 ? Accessory : sel == 2 ? Cap : sel == 3 ? Cape : sel == 4 ? Coat : sel == 5 ? Glove : sel == 6 ? LongCoat : sel == 7 ? Pants : sel == 8 ? Ring : sel == 9 ? Shoes : Weapon;
		if (seld == 1) {
			cm.sendYesNo("#fs14##fc0xFF000000#해외 캐시 아이템을 뽑을거야?");
		} else if (seld == 2) {
			var msg = "#fs14#원하는 아이템을 선택해#fs14#"+enter;
			for (i = 0; i < selected.length; i++) {
				msg += "#b#L"+i+"##i"+selected[i]+"##z"+selected[i]+"##k"+enter;
 			}
			cm.sendSimple(msg);
		} else if (seld == 3) {
			var msg = "#fs14##fc0xFF000000#뽑을 수 있는 품목은 아래와 같아!#fs14#"+enter;
			for (i = 0; i < selected.length; i++) {
				msg += "#b#i"+selected[i]+"##z"+selected[i]+"##k"+enter;
 			}
			cm.sendOk(msg);
			cm.dispose();
		}
	} else if (status == 3) {
		if (seld == 1) {
				item = selected[Randomizer.rand(0, selected.length)];
		ItemInfo = Packages.server.MapleItemInformationProvider.getInstance().getEquipById(item);
        ItemInfo.setStr(0);
        ItemInfo.setDex(0);
        ItemInfo.setInt(0);
        ItemInfo.setLuk(0);
        ItemInfo.setWatk(0);
        ItemInfo.setMatk(0);
        Packages.server.MapleInventoryManipulator.addFromDrop(cm.getClient(),ItemInfo,true);
				cm.sendOk("#fs14#짜잔! 어때? #b#i"+item+"##z"+item+"##k은(는) 맘에들어?");
				cm.dispose();
		} else {
			item = selected[sel];
			cm.sendYesNo("#fs14#정말로 #b#i"+item+"##z"+item+"##k을(를) 뽑을거야?");
		}
	} else if (status == 4) {
		ItemInfo = Packages.server.MapleItemInformationProvider.getInstance().getEquipById(item);
        ItemInfo.setStr(0);
        ItemInfo.setDex(0);
        ItemInfo.setInt(0);
        ItemInfo.setLuk(0);
        ItemInfo.setWatk(0);
        ItemInfo.setMatk(0);
        Packages.server.MapleInventoryManipulator.addFromDrop(cm.getClient(),ItemInfo,true);
			cm.sendOk("#fs14#짜잔! 어때? #b#i"+item+"##z"+item+"##k은(는) 맘에들어?");
			cm.dispose();
	}
}