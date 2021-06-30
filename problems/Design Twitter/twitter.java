class Twitter {

    /** Initialize your data structure here. */
    public Twitter() {
        _userFollows = new HashMap<>();
        _followUsers = new HashMap<>();
        _feeds = new HashMap<>();
        _tweets = new ArrayList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        _tweets.add(new int[] {userId, tweetId});

        if (!_feeds.containsKey(userId)) {
            _feeds.put(userId, new ArrayList<>());
        }

        _feeds.get(userId).add(0, tweetId);

        if (10 < _feeds.get(userId).size()) {
            _feeds.get(userId).remove(10);
        }

        if (_followUsers.containsKey(userId)) {
            HashSet<Integer> users = _followUsers.get(userId);

            for (int user : users) {
                _feeds.get(user).add(0, tweetId);

                if (10 < _feeds.get(user).size()) {
                    _feeds.get(user).remove(10);
                }
            }
        }

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!_feeds.containsKey(userId)) {
            _feeds.put(userId, new ArrayList<>());
        }

        return _feeds.get(userId);
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!_userFollows.containsKey(followerId)) {
            _userFollows.put(followerId, new HashSet<>());
        }

        _userFollows.get(followerId).add(followeeId);

        if (!_followUsers.containsKey(followeeId)) {
            _followUsers.put(followeeId, new HashSet<>());
        }

        _followUsers.get(followeeId).add(followerId);

        if (_feeds.containsKey(followerId)) {
            _feeds.get(followerId).clear();
        } else {
            _feeds.put(followerId, new ArrayList<>());
        }

        for (int idx = _tweets.size() - 1; 0 <= idx; --idx) {
            if (10 == _feeds.get(followerId).size()) {
                break;
            }

            if (_tweets.get(idx)[0] == followerId || _userFollows.containsKey(followerId) && _userFollows.get(followerId).contains(_tweets.get(idx)[0])) {
                _feeds.get(followerId).add(_tweets.get(idx)[1]);
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!_userFollows.containsKey(followerId)) {
            _userFollows.put(followerId, new HashSet<>());
        }

        _userFollows.get(followerId).remove(followeeId);

        if (!_followUsers.containsKey(followeeId)) {
            _followUsers.put(followeeId, new HashSet<>());
        }

        _followUsers.get(followeeId).remove(followerId);

        if (_feeds.containsKey(followerId)) {
            _feeds.get(followerId).clear();
        } else {
            _feeds.put(followerId, new ArrayList<>());
        }

        for (int idx = _tweets.size() - 1; 0 <= idx; --idx) {
            if (10 == _feeds.get(followerId).size()) {
                break;
            }

            if (_tweets.get(idx)[0] == followerId || _userFollows.containsKey(followerId) && _userFollows.get(followerId).contains(_tweets.get(idx)[0])) {
                _feeds.get(followerId).add(_tweets.get(idx)[1]);
            }
        }
    }

    HashMap<Integer, HashSet<Integer>> _followUsers;
    HashMap<Integer, HashSet<Integer>> _userFollows;
    HashMap<Integer, List<Integer>> _feeds;
    List<int[]> _tweets;

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
