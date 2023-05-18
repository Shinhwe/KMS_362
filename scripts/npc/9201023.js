importPackage(Packages.constants);
importPackage(Packages.packet.creators);importPackage(Packages.client.items);
importPackage(Packages.server.items);
importPackage(Packages.launch.world);
importPackage(Packages.main.world);
importPackage(Packages.database.hikari);
importPackage(java.lang);
importPackage(Packages.server);
importPackage(Packages.packet.creators);
importPackage(Packages.client.items);
importPackage(Packages.server.items);
importPackage(Packages.launch.world);
importPackage(Packages.main.world);
importPackage(Packages.database);
importPackage(java.lang);
importPackage(Packages.tools.packet);
importPackage(Packages.constants.programs);
importPackage(Packages.database);
importPackage(java.lang);
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
importPackage(Packages.tools.packet);
importPackage(Packages.constants);
importPackage(Packages.client.inventory);
importPackage(Packages.constants);
importPackage(Packages.server.items);
importPackage(Packages.client.items);
importPackage(java.lang);
importPackage(Packages.launch.world);
importPackage(Packages.packet.creators);
importPackage(Packages.tools.packet);
importPackage(Packages.constants.programs);
importPackage(Packages.database);
importPackage(java.lang);
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


function start()
{
	St = -1;
	rotation = 0;
	action(1, 0, 0);
}

function send(i, str)
{
	/*
		20 : "������"
		21 : "������ Ȯ����"
		22 : "�Ķ��� [�����] �Ķ���"
		23 : "���"
		24 : "�Ķ��� [�����(����)] �Ķ���"
		25 : "�̸� : ���� (���� Ȯ����)"
		26 : "������ [���] ������"
		27 : "���" (=23)
		28 : "������" (��������)
		30 : "����"
	*/
	cm.getPlayer().dropMessage(6, str);
}

function Comma(i)
{
	var reg = /(^[+-]?\d+)(\d{3})/;
	i+= '';
	while (reg.test(i))
	i = i.replace(reg, '$1' + ',' + '$2');
	return i;
}

function action(M, T, S)
{
	if(M != 1)
	{
		cm.dispose();
		return;
	}


	if(M == 1)
        {
	    St++;
	} 
        else
        {
            St--;
        }

	if(St == 0)
	{
		if(!cm.getPlayer().isGM())
		{
			cm.sendOk("�ȳ��ϼ���? �����ÿ��带 �����ϴ� ���� ��ſ�Ű���?");
			cm.dispose();
			return;
		}
		cm.sendSimple("�ȳ��ϼ���? �����ÿ��带 �����ϴ� ���� ��ſ�Ű���?\r\n"
			+ "#L0##r��ȭ�� ������.#l\r\n"
			+ "#L1##b�������� �ɼ��� �����Ѵ�.#l\r\n"
			+ "#L2##b����ɷ� �ڵ带 Ȯ���Ѵ�.#l");
	}

	else if(St == 1)
	{
		S1 = S;
		switch(S1)
		{
			case 1:
			inz = cm.getInventory(1)
			txt = "���� #b#h ##k ���� �����ϰ� �ִ� ��� ������ ����Դϴ�. �κ��丮�� ���ĵ�#fs14#� ��µǾ����� #r�ɼ��� �����ϰ� ���� ������#k�� �������ּ���.\r\n#b#fs11#";
			for(w = 0; w < inz.getSlotLimit(); w++)
			{
				if(!inz.getItem(w))
				{
					continue;
				}
				txt += "#L"+ w +"##i"+inz.getItem(w).getItemId()+":# #t"+inz.getItem(w).getItemId()+"##l\r\n";
			}
			cm.sendSimple(txt);
			break;

			case 2:
			send(00, "����");
			send(00, "����");
			send(00, "����");
			send(10, "��< �ֿ� ����% ���� ����ɷ� �ڵ� >");
			send(20, "������: +3%(10041)������: +6%(20041)������: +9%(30041)������: +12%(40041)"); 
			send(20, "������: +3%(10042)������: +6%(20042)������: +9%(30042)������: +12%(40042)");
			send(20, "����Ʈ: +3%(10043)����Ʈ: +6%(20043)����Ʈ: +9%(30043)����Ʈ: +12%(40043)");
			send(20, "������: +3%(10044)������: +6%(20044)������: +9%(30044)������: +12%(40044)"); 
			send(20, "���ý���: +9%(40086)����     �ý���: +12%(40081)������  �ý���: +20%(60002)");
			send(27, "����");
			send(10, "��< ��Ÿ ����% ���� ����ɷ� �ڵ� >");
			send(20, "���ִ�ü��: +3%(10045)���ִ�ü��: +6%(20045)���ִ�ü��: +9% (30045)���ִ�ü��: +12%(40045)");
			send(20, "���ִ븶��: +3%(10046)���ִ븶��: +6%(20046)���ִ븶��: +9% (30046)���ִ븶��: +12%(40046)");
			send(20, "��ȸ��ġ��: +3%(10048)��ȸ��ġ��: +6%(20048)��ȸ��ġ��: +9% (30048)��ȸ��ġ��: +12%(40048)");
			send(27, "����");
			send(10, "��< ���� ���� ����ɷ� �ڵ� >");
			send(27, "��������: +6%(20070)��������: +9%(30070)��������: +12%(40070)");
			send(27, "�����ݷ�: +6%(20051)�����ݷ�: +9%(30051)�����ݷ�: +12%(40051)");
			send(27, "�����¡�: +6%(20052)�����¡�: +9%(30052)�����¡�: +12%(40052)");
			send(27, "����");
			send(10, "��< ���� ����� ���� ���� ����ɷ� �ڵ� >");
			send(27, "��+15%(10291)��+20%(20291)��+30%(30291)��+35%(40291)��+40%(40292)");
			send(27, "����");
			send(10, "��< ���� ���� ���ݽ� ������ ���� ����ɷ� �ڵ� >");
			send(27, "��+20%(30601)��+25%(40601)��+30%(30602)��+35%(40602)��+40%(40603)");
			send(27, "����");
			send(10, "��< ũ��Ƽ�� ���� ����ɷ� �ڵ� >");
			send(27, "��ũ��Ƽ�� �ߵ�: +8%(20055)��ũ��Ƽ�� �ߵ�: +10%(30055)��ũ��Ƽ�� �ߵ�: +12%(40055)");
			send(27, "��ũ��Ƽ�� �ּ� ������: +15%(40056)��������������  ũ��Ƽ�� �ִ� ������: +15%(40057)");
			send(27, "����");
			send(10, "��< ��ű� �� �� ���� ����ɷ� �ڵ� >");
			send(05, "���޼� ȹ�淮 ����: +20%(40650)�������� ȹ�� Ȯ�� ����: +20%(40656)");
			send(05, "���ǰ� �� �����ð�: 1��(20366)�����ǰ� �� �����ð�: 2��(30366)�����ǰ� �� �����ð�: 3��(40366)");
			send(27, "����");
			send(10, "��< ������ ��ų ���� ����ɷ� �ڵ� >");
			send(05, "��(����ũ)�� ���̽�Ʈ(31001)���̽�ƽ ����(31002)������ ������(31003)�������� �ٵ�(31004)");
			send(05, "��(�����帮) �Ĺ� ������(41005)������  ���꽺�� ������(41006)������  ���� �ν���(41007)");
			cm.getPlayer().dropMessage(1, "ä��â�� �ִ�� Ȯ���ϸ� ��� ������ ǥ�õ˴ϴ�.");
                              //World.Broadcast.broadcastMessage(CField.getGameMessage(28, "test"));
			cm.dispose();
			break;
			default:
			cm.dispose();
			break;
		}
	}

	else if(St > 1)
	{
		if(rotation != -1)
		{
			switch(St)
			{
				case 2: S2 = S; break;
				case 3: S3 = S; break;
				case 4: S4 = S; break;
			}
                        if (St ==4 && rotation == 2)
			{
			inz.setArc(3000);
				switch(S3)
				{
					case 0: inz.setStr(S4); break;
					case 1: inz.setDex(S4); break;
					case 2: inz.setInt(S4); break;
					case 3: inz.setLuk(S4); break;
					case 4: inz.setHp(S4); break;
					case 5: inz.setMp(S4); break;
					case 6: inz.setWatk(S4); break;
					case 7: inz.setMatk(S4); break;
					case 8: inz.setWdef(S4); break;
					case 9: inz.setMdef(S4); break;
					case 10: inz.setAcc(S4); break;
					case 11: inz.setAvoid(S4); break;
					case 12: inz.setSpeed(S4); break;
					case 13: inz.setJump(S4); break;
					case 14: inz.setLevel(S4); break;
					case 15: inz.setUpgradeSlots(S4); break;
					case 16: inz.setStarForceLevel(S4); break;
					case 17: inz.setAmazingequipscroll(true); break;
					case 18: inz.setBossDamage(S4); break;
					case 19: inz.setIgnorePDR(S4); break;
					case 20: inz.setTotalDamage(S4); break;
					case 21: inz.setAllStat(S4); break;
					case 22: inz.setDownLevel(-S4); break;
					case 23: inz.setState(S4); break;
					case 24: inz.setPotential1(S4); break;
					case 25: inz.setPotential2(S4); break;
					case 26: inz.setPotential3(S4); break;
					case 27: inz.setPotential4(S4); break;
					case 28: inz.setPotential5(S4); break;
					case 29: inz.setPotential6(S4); break;
					case 30: inz.setArcLevel(S4); break;
					case 31: inz.setArc(S4); break;
					case 32: inz.setArcEXP(S4); break;
				}
		        cm.getPlayer().forceReAddItem(inz, Packages.client.inventory.MapleInventoryType.EQUIP);
                        rotation = 0;
			St = 2;
                        }
		}
		else
		{
			S2 = S2;
			rotation++;
		}
                
		addItemInfo();
	}
}

function addItemInfo()
{
	if(rotation == 0)
	{
		inz = cm.getInventory(1).getItem(S2);
		txt = "#r#e[������ �⺻#fs14#n\r\n#b#fs11#";
		sel = ["��", "����", "��Ʈ", "��", "�ִ� ü��(HP)", "�ִ� ����(MP)", "���ݷ�", "����", "��������", "��������", "���߷�", "ȸ��ġ", "���ǵ�", "������", "�ֹ��� ���� Ƚ��", "���׷��̵� ���� Ƚ��", "��Ÿ���� ���� Ƚ��", "���� ��� ���� Ƚ��", "���� ���� �� ������", "���� ���� ����", "�� ������", "�ý���", "���� ���� ����", "����ɷ� ���", "1 ��° ����ɷ�", "2 ��° ����ɷ�", "3 ��° ����ɷ�", "4 ��° ����ɷ�", "5 ��° ����ɷ�", "6 ��° ����ɷ�", "������ ���� ����", "������ ���� ��ġ", "������ ���� ����ġ"];
		for(y = 0; y < sel.length; y++)
		{
			txt += "#L"+ y +"#"+sel[y]+"#l";
			if(y == 5 || y == 9 || y == 15 || y == 19 || y == 23 || y == 26)
			{
				txt += "\r\n";
			}
			if(y == 13)
			{
				txt += "\r\n\r\n\r\n#r#e#fs12#[������ �#fs14#]#b#n#fs11#\r\n";
			}
			if(y == 17)
			{
				txt += "\r\n\r\n\r\n#r#e#fs12#[������ �#fs14#]#b#n#fs11#\r\n";
			}
			if(y == 22)
			{
				txt += "\r\n\r\n\r\n#r#e#fs12#[������ �#fs14#�]#b#n#fs11#\r\n";
			}
			if(y == 29)
			{
				txt += "\r\n\r\n\r\n#r#e#fs12#[������ �#fs14#�]#b#n#fs11#\r\n";
			}

		}
		cm.sendSimple(txt);
		rotation++;
	}

	else if(rotation == 1)
	{
		switch(S3)
		{
			//STR, DEX, INT, LUK, MaxHp, MaxMp, Watk, Matk, PDD, MDD, ACC, AVOID, SPEED, JUMP, ARC
			case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11: case 12: case 13: case 31:
			max = 32767;
			break;

			//LEVEL, SLOT
			case 14: case 15:
			max = 127;
			break;

			//STARFORCE, ENHANCE
			case 16: case 17: case 32:
			max = 255;
			break;

			//ADDOPTIONS
			case 18: case 19: case 20: case 21: case 22:
			max = 100;
			break;

			case 30:
			max = 20;
			break;

			default:
			max = 99999;
			break;
		}

		if(S3 != 23)
		{
			if(max != 99999)
			{
				cm.sendGetNumber("������ ���ϴ� #b"+sel[S3]+"#k ��ġ�� ���� �Է����ּ���.\r\n#r(#e"+Comma(max)+"#n ���� ���� ���� �Է��� �� ����ϴ�.)", 0, 0, max);
			}
			else
			{
				cm.sendGetNumber("������ ���ϴ� #b"+sel[S3]+"#k ��ġ�� ���� �Է����ּ���.\r\n#r(����ɷ� �ڵ带 �𸥴ٸ� ���� ���� Ȯ���� �����ϴ�ϴ�.)", 0, 0, max);
			}				
		}
		else
		{
			cm.sendSimple("������ ���ϴ� #b"+sel[S3]+"#k ��ġ�#fs14# �������ּ���.\r\n#fs11##r"
				+ "#L0#����ɷ� ��� ����#l\r\n\r\n\r\n"
				+ "#fs12##e[��Ȯ�� ����#fs14#]#b#n#fs11#\r\n"
				+ "#L1#����#l#L2#����#l#L3#����ũ#l#L4#�����帮#l\r\n\r\n\r\n"
				+ "#fs12##e#r[Ȯ�ε� ����ɷ#fs14##b#n#fs11#\r\n"
				+ "#L17#����#l#L18#����#l#L19#����ũ#l#L20#�����帮#l\r\n");
		}
		rotation++;
	}
}		