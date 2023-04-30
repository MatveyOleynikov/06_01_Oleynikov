package tests.SpiderWeb;

import Model.Direction;
import Model.SpiderWeb;
import org.junit.Assert;
import org.junit.Test;

public class testZone {
    @Test
    public void zoneExist(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Assert.assertEquals(spiderWeb.zone(1, 1), spiderWeb.zone(spiderWeb.zone(2, 1), Direction.north()));
    }


    @Test
    public void zoneNotExist(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Assert.assertNull(spiderWeb.zone(spiderWeb.zone(0, 1), Direction.north()));

    }

    @Test
    public void south(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Assert.assertEquals(spiderWeb.zone(2, 1), spiderWeb.zone(spiderWeb.zone(1, 1), Direction.south()));
    }

    @Test
    public void west(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Assert.assertEquals(spiderWeb.zone(1, 0), spiderWeb.zone(spiderWeb.zone(1, 1), Direction.west()));
    }

    @Test
    public void east(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Assert.assertEquals(spiderWeb.zone(1, 2), spiderWeb.zone(spiderWeb.zone(1, 1), Direction.east()));
    }
}
