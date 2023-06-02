/*
 * ǻ��¶��� �ҽ� ��ũ��Ʈ �Դϴ�.
 * 
 * ��Ż��ġ : ������ ���� 1
 * ��Ż���� : ���� �Ӹ� ��ȯ
 * 
 * ���� : ��ũ����
 * 
 */
importPackage(Packages.server.life);
function enter(pi) {
    //2408003������ ��ġ�� 8810024, 8810128 ��ȯ
    var map = pi.getPlayer().getMap();
    if (map.getReactor(2408003).getState() <= 0) {
        var pos = map.getReactor(2408003).getPosition();
        var mob = null;
        if (isChaos(pi) == 0) {
            mob = MapleLifeProvider.getMonster(8810024);
        } else {
            mob = MapleLifeProvider.getMonster(8810128);
        }
        pi.getPlayer().getMap().spawnMonsterOnGroundBelow(mob, pos);
        map.getReactor(2408003).setPotentialLevel(1);
    }
    return false;
}


function isChaos(pi) {
    return pi.getClient().getChannel() % 2;
}