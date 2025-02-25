package cs113.listGame.resources;

import cs113.listGame.gamecore.GameObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ResourceArrayList implements ResourceList {
    @Override
    public void add(ResourceObject resource) {

    }

    @Override
    public void remove(ResourceObject resource) {

    }

    @Override
    public void truncate(ResourceObject resource) {

    }

    @Override
    public void follow(GameObject leader) {
    Iterator<ResourceObject> it = resources.iterator();
    while (it.hasNext()) {
        ResourceObject resource = it.next();
        resource.moveTowards(leader.getEchoCenter());
        leader = resource;
    }
    }
}
