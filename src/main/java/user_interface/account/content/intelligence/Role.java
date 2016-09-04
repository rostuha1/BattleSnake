package user_interface.account.content.intelligence;

import javafx.beans.NamedArg;

import java.util.ArrayList;
import java.util.Arrays;

public enum Role {
    OWN_HEAD(1), OWN_BODY(2), OWN_TAIL(3), ENEMY_HEAD(4), ENEMY_BODY(5), ENEMY_TAIL(6), BARRIER(7), EMPTY(8),
    A_O_OWN_HEAD(9), A_O_OWN_BODY(10), A_O_OWN_TAIL(11), A_O_ENEMY_HEAD(12), A_O_ENEMY_BODY(13), A_O_ENEMY_TAIL(14), A_O_BARRIER(15), A_O_EMPTY(16),
    A_P_OWN_HEAD(17), A_P_OWN_BODY(18), A_P_OWN_TAIL(19), A_P_ENEMY_HEAD(20), A_P_ENEMY_BODY(21), A_P_ENEMY_TAIL(22), A_P_BARRIER(23), A_P_EMPTY(24),
    OR_OWN_HEAD(25), OR_OWN_BODY(26), OR_OWN_TAIL(27), OR_ENEMY_HEAD(28), OR_ENEMY_BODY(29), OR_ENEMY_TAIL(30), OR_BARRIER(31), OR_EMPTY(32),
    EXCEPT_OWN_HEAD(33), EXCEPT_OWN_BODY(34), EXCEPT_OWN_TAIL(35), EXCEPT_ENEMY_HEAD(36), EXCEPT_ENEMY_BODY(37), EXCEPT_ENEMY_TAIL(38), EXCEPT_BARRIER(39), EXCEPT_EMPTY(40),
    EXCEPT(41);

    public final int key;

    Role(int key) {
        this.key = key;
    }

    public static final Role[] ownHeads = { OWN_HEAD, A_O_OWN_HEAD, A_P_OWN_HEAD, OR_OWN_HEAD, EXCEPT_OWN_HEAD };
    public static final Role[] ownBodies = { OWN_BODY, A_O_OWN_BODY, A_P_OWN_BODY, OR_OWN_BODY, EXCEPT_OWN_BODY };
    public static final Role[] ownTails = { OWN_TAIL, A_O_OWN_TAIL, A_P_OWN_TAIL, OR_OWN_TAIL, EXCEPT_OWN_TAIL };
    public static final Role[] enemyHeads = { ENEMY_HEAD, A_O_ENEMY_HEAD, A_P_ENEMY_HEAD, OR_ENEMY_HEAD, EXCEPT_ENEMY_HEAD };
    public static final Role[] enemyBodies = { ENEMY_BODY, A_O_ENEMY_BODY, A_P_ENEMY_BODY, OR_ENEMY_BODY, EXCEPT_ENEMY_BODY };
    public static final Role[] enemyTails = { ENEMY_TAIL, A_O_ENEMY_TAIL, A_P_ENEMY_TAIL, OR_ENEMY_TAIL, EXCEPT_ENEMY_TAIL };
    public static final Role[] barriers = { BARRIER, A_O_BARRIER, A_P_BARRIER, OR_BARRIER, EXCEPT_BARRIER };
    public static final Role[] empties = { EMPTY, A_O_EMPTY, A_P_EMPTY, OR_EMPTY, EXCEPT_EMPTY };

    public static final ArrayList<Role[]> rolesArrayList = new ArrayList<>(8);

    private static final String andOrangeDirectory = "and_orange/";
    private static final String andPinkDirectory = "and_pink/";
    private static final String orDirectory = "or/";
    private static final String exceptDirectory = "except/";

    private static final Image ownHead = new Image(IntelligenceContent.cardElementImagesPath + "own_head.png").setGroup(ownHeads);
    private static final Image ownBody = new Image(IntelligenceContent.cardElementImagesPath + "own_body.png").setGroup(ownBodies);
    private static final Image ownTail = new Image(IntelligenceContent.cardElementImagesPath + "own_tail.png").setGroup(ownTails);
    private static final Image enemyHead = new Image(IntelligenceContent.cardElementImagesPath + "enemy_head.png").setGroup(enemyHeads);
    private static final Image enemyBody = new Image(IntelligenceContent.cardElementImagesPath + "enemy_body.png").setGroup(enemyBodies);
    private static final Image enemyTail = new Image(IntelligenceContent.cardElementImagesPath + "enemy_tail.png").setGroup(enemyTails);
    private static final Image barrier = new Image(IntelligenceContent.cardElementImagesPath + "barrier.png").setGroup(barriers);
    private static final Image empty = new Image(IntelligenceContent.cardElementImagesPath + "empty.png").setGroup(empties);

    private static final Image aoOwnHead = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "own_head.png").setGroup(ownHeads);
    private static final Image aoOwnBody = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "own_body.png").setGroup(ownBodies);
    private static final Image aoOwnTail = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "own_tail.png").setGroup(ownTails);
    private static final Image aoEnemyHead = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "enemy_head.png").setGroup(enemyHeads);
    private static final Image aoEnemyBody = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "enemy_body.png").setGroup(enemyBodies);
    private static final Image aoEnemyTail = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "enemy_tail.png").setGroup(enemyTails);
    private static final Image aoBarrier = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "barrier.png").setGroup(barriers);
    private static final Image aoEmpty = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "empty.png").setGroup(empties);

    private static final Image apOwnHead = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "own_head.png").setGroup(ownHeads);
    private static final Image apOwnBody = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "own_body.png").setGroup(ownBodies);
    private static final Image apOwnTail = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "own_tail.png").setGroup(ownTails);
    private static final Image apEnemyHead = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "enemy_head.png").setGroup(enemyHeads);
    private static final Image apEnemyBody = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "enemy_body.png").setGroup(enemyBodies);
    private static final Image apEnemyTail = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "enemy_tail.png").setGroup(enemyTails);
    private static final Image apBarrier = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "barrier.png").setGroup(barriers);
    private static final Image apEmpty = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "empty.png").setGroup(empties);

    private static final Image orOwnHead = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "own_head.png").setGroup(ownHeads);
    private static final Image orOwnBody = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "own_body.png").setGroup(ownBodies);
    private static final Image orOwnTail = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "own_tail.png").setGroup(ownTails);
    private static final Image orEnemyHead = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "enemy_head.png").setGroup(enemyHeads);
    private static final Image orEnemyBody = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "enemy_body.png").setGroup(enemyBodies);
    private static final Image orEnemyTail = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "enemy_tail.png").setGroup(enemyTails);
    private static final Image orBarrier = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "barrier.png").setGroup(barriers);
    private static final Image orEmpty = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "empty.png").setGroup(empties);

    private static final Image exceptOwnHead = new Image(IntelligenceContent.cardElementImagesPath + exceptDirectory + "own_head.png").setGroup(ownHeads);
    private static final Image exceptOwnBody = new Image(IntelligenceContent.cardElementImagesPath + exceptDirectory + "own_body.png").setGroup(ownBodies);
    private static final Image exceptOwnTail = new Image(IntelligenceContent.cardElementImagesPath + exceptDirectory + "own_tail.png").setGroup(ownTails);
    private static final Image exceptEnemyHead = new Image(IntelligenceContent.cardElementImagesPath + exceptDirectory + "enemy_head.png").setGroup(enemyHeads);
    private static final Image exceptEnemyBody = new Image(IntelligenceContent.cardElementImagesPath + exceptDirectory + "enemy_body.png").setGroup(enemyBodies);
    private static final Image exceptEnemyTail = new Image(IntelligenceContent.cardElementImagesPath + exceptDirectory + "enemy_tail.png").setGroup(enemyTails);
    private static final Image exceptBarrier = new Image(IntelligenceContent.cardElementImagesPath + exceptDirectory + "barrier.png").setGroup(barriers);
    private static final Image exceptEmpty = new Image(IntelligenceContent.cardElementImagesPath + exceptDirectory + "empty.png").setGroup(empties);

    private static final Image except = new Image(IntelligenceContent.cardElementImagesPath + "except.png");

    public static final Role[] simpleElements = new Role[8];
    public static final Role[] aoElements = new Role[8];
    public static final Role[] apElements = new Role[8];
    public static final Role[] orElements = new Role[8];
    public static final Role[] exceptElements = new Role[8];

    static {
        rolesArrayList.add(ownHeads);
        rolesArrayList.add(ownBodies);
        rolesArrayList.add(ownTails);
        rolesArrayList.add(enemyHeads);
        rolesArrayList.add(enemyBodies);
        rolesArrayList.add(enemyTails);
        rolesArrayList.add(barriers);
        rolesArrayList.add(empties);

        for (int i = 0; i < 8; i++) {
            simpleElements[i] = rolesArrayList.get(i)[0];
            aoElements[i] = rolesArrayList.get(i)[1];
            apElements[i] = rolesArrayList.get(i)[2];
            orElements[i] = rolesArrayList.get(i)[3];
            exceptElements[i] = rolesArrayList.get(i)[4];
        }

    }

    public static Role getRoleByKey(int key) {
        for (Role role : Role.values()) {
            if (role.key == key) return role;
        }
        return null;
    }

    public static Image getElementImage(Role role) {
        switch (role) {
            case OWN_HEAD: return ownHead;
            case OWN_BODY: return ownBody;
            case OWN_TAIL: return ownTail;
            case ENEMY_HEAD: return enemyHead;
            case ENEMY_BODY: return enemyBody;
            case ENEMY_TAIL: return enemyTail;
            case BARRIER: return barrier;
            case EMPTY: return empty;

            case A_O_OWN_HEAD: return aoOwnHead;
            case A_O_OWN_BODY: return aoOwnBody;
            case A_O_OWN_TAIL: return aoOwnTail;
            case A_O_ENEMY_HEAD: return aoEnemyHead;
            case A_O_ENEMY_BODY: return aoEnemyBody;
            case A_O_ENEMY_TAIL: return aoEnemyTail;
            case A_O_BARRIER: return aoBarrier;
            case A_O_EMPTY: return aoEmpty;

            case A_P_OWN_HEAD: return apOwnHead;
            case A_P_OWN_BODY: return apOwnBody;
            case A_P_OWN_TAIL: return apOwnTail;
            case A_P_ENEMY_HEAD: return apEnemyHead;
            case A_P_ENEMY_BODY: return apEnemyBody;
            case A_P_ENEMY_TAIL: return apEnemyTail;
            case A_P_BARRIER: return apBarrier;
            case A_P_EMPTY: return apEmpty;

            case OR_OWN_HEAD: return orOwnHead;
            case OR_OWN_BODY: return orOwnBody;
            case OR_OWN_TAIL: return orOwnTail;
            case OR_ENEMY_HEAD: return orEnemyHead;
            case OR_ENEMY_BODY: return orEnemyBody;
            case OR_ENEMY_TAIL: return orEnemyTail;
            case OR_BARRIER: return orBarrier;
            case OR_EMPTY: return orEmpty;

            case EXCEPT_OWN_HEAD: return exceptOwnHead;
            case EXCEPT_OWN_BODY: return exceptOwnBody;
            case EXCEPT_OWN_TAIL: return exceptOwnTail;
            case EXCEPT_ENEMY_HEAD: return exceptEnemyHead;
            case EXCEPT_ENEMY_BODY: return exceptEnemyBody;
            case EXCEPT_ENEMY_TAIL: return exceptEnemyTail;
            case EXCEPT_BARRIER: return exceptBarrier;
            case EXCEPT_EMPTY: return exceptEmpty;

            case EXCEPT: return except;

            default: return null;
        }
    }

    public static boolean isSimpleElement(Role role) {
        return Arrays.binarySearch(simpleElements, role) >= 0;
    }
    public static boolean isAOElement(Role role) {
        return Arrays.binarySearch(aoElements, role) >= 0;
    }
    public static boolean isAPElement(Role role) {
        return Arrays.binarySearch(apElements, role) >= 0;
    }
    public static boolean isOrElement(Role role) {
        return Arrays.binarySearch(orElements, role) >= 0;
    }
    public static boolean isExceptElement(Role role) {
        return Arrays.binarySearch(exceptElements, role) >= 0;
    }

    public static boolean isOwnHead(Role role) {
        return Arrays.binarySearch(ownHeads, role) >= 0;
    }
    public static boolean isOwnBody(Role role) {
        return Arrays.binarySearch(ownBodies, role) >= 0;
    }
    public static boolean isOwnTail(Role role) {
        return Arrays.binarySearch(ownTails, role) >= 0;
    }
    public static boolean isEnemyHead(Role role) {
        return Arrays.binarySearch(enemyHeads, role) >= 0;
    }
    public static boolean isEnemyBody(Role role) {
        return Arrays.binarySearch(enemyBodies, role) >= 0;
    }
    public static boolean isEnemyTail(Role role) {
        return Arrays.binarySearch(enemyTails, role) >= 0;
    }
    public static boolean isBarrier(Role role) {
        return Arrays.binarySearch(barriers, role) >= 0;
    }
    public static boolean isEmpty(Role role) {
        return Arrays.binarySearch(empties, role) >= 0;
    }

    public static class Image extends javafx.scene.image.Image{

        Role[] group;

        public Image(@NamedArg("url") String url) {
            super(url);
        }

        public Image setGroup(Role[] group) {
            this.group = group;
            return this;
        }
        public Role[] getGroup() {
            return group;
        }

    }

}
