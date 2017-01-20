import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by S N Rao on 1/19/2017.
 *
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see
 * the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
 *      be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least
 *      recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 */
public class DesignTwitterLeetCode {

    public class Twitter {

        /** Initialize your data structure here. */
        List<Integer> tweets;
        HashMap<Integer,HashSet<Integer>> following;
        HashMap<Integer,Integer> tweetMap;
        public Twitter() {
            tweets=new ArrayList<>();
            tweetMap=new HashMap<>();
            following=new HashMap<>();
        }

        public void createUser(int userId){
            following.put(userId,new HashSet<>());
            following.get(userId).add(userId);
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!following.containsKey(userId))
                createUser(userId);
            tweets.add(tweetId);
            tweetMap.put(tweetId,userId);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            if(!following.containsKey(userId)) return new ArrayList<>();
            int count=0,i=tweets.size()-1;
            List<Integer> feed=new ArrayList<>();
            HashSet<Integer> followingUsers=following.get(userId);
            while(count<10 && i>=0){
                int tweet=tweets.get(i);
                int tweeter=tweetMap.get(tweet);
                if(followingUsers.contains(tweeter)){
                    feed.add(tweet);
                    count++;
                }
                i--;
            }
            return feed;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(!following.containsKey(followerId))
                createUser(followerId);
            if(!following.containsKey(followeeId))
                createUser(followeeId);
            following.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(following.containsKey(followerId) && followerId!=followeeId)
                following.get(followerId).remove(followeeId);
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
