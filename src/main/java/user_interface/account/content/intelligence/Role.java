package user_interface.account.content.intelligence;

import javafx.beans.NamedArg;
import javafx.scene.image.Image;

public enum Role {
    OWN_HEAD, OWN_BODY, OWN_TAIL, ENEMY_HEAD, ENEMY_BODY, ENEMY_TAIL, BARRIER, EMPTY,
    A_O_OWN_HEAD, A_O_OWN_BODY, A_O_OWN_TAIL, A_O_ENEMY_HEAD, A_O_ENEMY_BODY, A_O_ENEMY_TAIL, A_O_BARRIER, A_O_EMPTY,
    A_P_OWN_HEAD, A_P_OWN_BODY, A_P_OWN_TAIL, A_P_ENEMY_HEAD, A_P_ENEMY_BODY, A_P_ENEMY_TAIL, A_P_BARRIER, A_P_EMPTY,
    OR_OWN_HEAD, OR_OWN_BODY, OR_OWN_TAIL, OR_ENEMY_HEAD, OR_ENEMY_BODY, OR_ENEMY_TAIL, OR_BARRIER, OR_EMPTY;

    private static final String andOrangeDirectory = "and_orange/";
    private static final String andPinkDirectory = "and_pink/";
    private static final String orDirectory = "or/";

    private static final Image ownHead = new Image(IntelligenceContent.cardElementImagesPath + "own_head.png");
    private static final Image ownBody = new Image(IntelligenceContent.cardElementImagesPath + "own_body.png");
    private static final Image ownTail = new Image(IntelligenceContent.cardElementImagesPath + "own_tail.png");
    private static final Image enemyHead = new Image(IntelligenceContent.cardElementImagesPath + "enemy_head.png");
    private static final Image enemyBody = new Image(IntelligenceContent.cardElementImagesPath + "enemy_body.png");
    private static final Image enemyTail = new Image(IntelligenceContent.cardElementImagesPath + "enemy_tail.png");
    private static final Image barrier = new Image(IntelligenceContent.cardElementImagesPath + "barrier.png");
    private static final Image empty = new Image(IntelligenceContent.cardElementImagesPath + "empty.png");

    private static final Image aoOwnHead = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "own_head.png");
    private static final Image aoOwnBody = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "own_body.png");
    private static final Image aoOwnTail = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "own_tail.png");
    private static final Image aoEnemyHead = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "enemy_head.png");
    private static final Image aoEnemyBody = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "enemy_body.png");
    private static final Image aoEnemyTail = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "enemy_tail.png");
    private static final Image aoBarrier = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "barrier.png");
    private static final Image aoEmpty = new Image(IntelligenceContent.cardElementImagesPath + andOrangeDirectory + "empty.png");

    private static final Image apOwnHead = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "own_head.png");
    private static final Image apOwnBody = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "own_body.png");
    private static final Image apOwnTail = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "own_tail.png");
    private static final Image apEnemyHead = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "enemy_head.png");
    private static final Image apEnemyBody = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "enemy_body.png");
    private static final Image apEnemyTail = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "enemy_tail.png");
    private static final Image apBarrier = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "barrier.png");
    private static final Image apEmpty = new Image(IntelligenceContent.cardElementImagesPath + andPinkDirectory + "empty.png");

    private static final Image orOwnHead = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "own_head.png");
    private static final Image orOwnBody = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "own_body.png");
    private static final Image orOwnTail = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "own_tail.png");
    private static final Image orEnemyHead = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "enemy_head.png");
    private static final Image orEnemyBody = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "enemy_body.png");
    private static final Image orEnemyTail = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "enemy_tail.png");
    private static final Image orBarrier = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "barrier.png");
    private static final Image orEmpty = new Image(IntelligenceContent.cardElementImagesPath + orDirectory + "empty.png");

//    private static final Image[] def = { ownHead, ownBody, ownTail, enemyHead, enemyBody, enemyTail, barrier, empty };
//    private static final Image[] ao = { aoOwnHead, aoOwnBody, aoOwnTail, aoEnemyHead, aoEnemyBody, aoEnemyTail, aoBarrier, aoEmpty };
//    private static final Image[] ap = { apOwnHead, apOwnBody, apOwnTail, apEnemyHead, apEnemyBody, apEnemyTail, apBarrier, apEmpty };
//    private static final Image[] or = { orOwnHead, orOwnBody, orOwnTail, orEnemyHead, orEnemyBody, orEnemyTail, orBarrier, orEmpty };

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

            default: return null;
        }
    }

//    private static class Image extends javafx.scene.image.Image{
//
//        public Image(@NamedArg("url") String url) {
//            super(url);
//        }
//    }

}
