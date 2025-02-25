package cs113.listGame.resources;

import cs113.listGame.gamecore.GameObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ResourceLinkedList implements ResourceList {
    LinkedList<ResourceObject> resources= new LinkedList<>();

    @Override
    public void add(ResourceObject resource) {
    resources.addLast(resource);
    }

    @Override
    public void remove(ResourceObject resource) {
    resources.remove(resource);
    }

    @Override
    public void truncate(ResourceObject resource) {
        boolean found = false;
        Iterator<ResourceObject> it = resources.iterator();
        while (it.hasNext()) {
            if (it.next().equals(resource)) {
                found = true;
            }
            if (found) {
                it.remove();
            }
        }
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
