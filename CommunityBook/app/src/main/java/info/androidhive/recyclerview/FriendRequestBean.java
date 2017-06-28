package info.androidhive.recyclerview;

/**
 * Created by rudresha on 10/06/17.
 */

public class FriendRequestBean {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMutualFriends() {
        return mutualFriends;
    }

    public void setMutualFriends(String mutualFriends) {
        this.mutualFriends = mutualFriends;
    }

    public String mutualFriends;
}
