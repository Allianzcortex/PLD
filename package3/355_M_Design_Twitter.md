
Problem description:

```

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 

Example 1:

Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
 

Constraints:

1 <= userId, followerId, followeeId <= 500
0 <= tweetId <= 104
All the tweets have unique IDs.
At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unfollow.

```

自己开始的解法搞的也太复杂了，下面的不仅没有 AC，也特别乱
因为自己一开始想的是 twitter 的 `fan out` 模型，其实根本没必要...

```Python

class User(object):
    
    def __init__(self):
        pass
    
    def 

class Twitter:
    
    """
    So for this problem, the key is :
    in which data structure we use to store the twitter relationships
    
    for each user, we use a heap to add all news
    """

    def __init__(self):
        
        # u1 follows u2 , so follow[u2]=[u2,u1]
        self.follower_map = defaultdict(set)
        
        self.following_map = defaultdict(set)
        
        # need a priorityqueue for each user
        self.tweets = defaultdict(list)
        
        # need a timestamp
        self.time = 1
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        
        tweet = [-1*self.time,userId,tweetId]
        
        for follower in self.follower_map[userId]:
            queue = self.tweets[follower]
            heappush(queue,tweet)
        
        heappush(self.tweets[userId],tweet)

    def getNewsFeed(self, userId: int) -> List[int]:
        
        cnt,res = 10,[]
        queue = self.tweets[userId]
        following = self.following_map[userId]
        while queue and cnt>0:
            _ ,uId,tweetId = heappop(queue)
            if uId==userId or uId in following:
                res.append(tweetId)
                cnt -= 1
        
        return res
        
    def follow(self, followerId: int, followeeId: int) -> None:
        
        self.follower_map[followeeId].add(followerId)
        self.following_map[followerId].add(followeeId)
        
    def unfollow(self, followerId: int, followeeId: int) -> None:
        
        self.follower_map[followeeId].remove(followerId)
        self.following_map[followerId].remove(followeeId)

```


下面是自己 AC 的解法：

```Python

class Twitter:
    
    def __init__(self):
        
        self.following_map = defaultdict(set)
        
        # need a priorityqueue for each user
        self.tweets = defaultdict(list)
        
        # need a timestamp
        self.time = 1
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        
        tweet = [-1*self.time,tweetId]
        
        self.tweets[userId].append(tweet)
        self.time += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        
        cnt,res = 10,[]
        tweets_list = []
        for followee in self.following_map[userId]:
            tweets_list.extend(self.tweets[followee])
        
        # add tweet of userself
        tweets_list.extend(self.tweets[userId])
        heapify(tweets_list)
        
        while tweets_list and cnt>0:
            _ ,tweetId = heappop(tweets_list)
            res.append(tweetId)
            cnt -= 1
        
        return res
        
    def follow(self, followerId: int, followeeId: int) -> None:
        
        self.following_map[followerId].add(followeeId)
        
    def unfollow(self, followerId: int, followeeId: int) -> None:
        
        if followeeId in self.following_map[followerId]:
            self.following_map[followerId].remove(followeeId)

```