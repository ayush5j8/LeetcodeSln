import java.util.*;
import java.time.Instant;
import java.util.stream.Collectors;

class Twitter {
    private Map<Integer, User> users;  // Maps userId to User object
    private List<Tweet> tweets;        // Stores all tweets
    
    public Twitter() {
        users = new HashMap<>();
        tweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        Tweet tweet = new Tweet(tweetId, userId, Instant.now());
        tweets.add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) return new ArrayList<>();

        User user = users.get(userId);
        Set<Integer> followings = user.following;
        followings.add(userId);  // Include user's own tweets

        return tweets.stream()
                .filter(tweet -> followings.contains(tweet.postedBy))
                .sorted((t1, t2) -> t2.postedOn.compareTo(t1.postedOn)) // Latest first
                .limit(10)
                .map(tweet -> tweet.id)
                .collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            users.get(followerId).following.remove(followeeId);
        }
    }
}

class User {
    int id;
    Set<Integer> following;

    User(int id) {
        this.id = id;
        this.following = new HashSet<>();
    }
}

class Tweet {
    int id;
    int postedBy;
    Instant postedOn;

    Tweet(int id, int postedBy, Instant postedOn) {
        this.id = id;
        this.postedBy = postedBy;
        this.postedOn = postedOn;
    }
}
