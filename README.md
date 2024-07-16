# Operation of the application

What can be done in this application is the following:

First we will talk about login since **JWT** is used so you can register a user or log in.
if the *user exists* in the database:
It is entered at this end point:
```http
POST http://localhost:8080/auth/log-in

{
"username":  "",
"password":  ""
}
```
This will generate a token that is good for **half an hour**.

If you are *not registered*, you will enter at this end point:
The full name is an optional field as is the bio the other fields are mandatory.
```http
POST http://localhost:8080/auth/sign-up
{
"username":  "",
"email":  "",
"password":  "",
"fullName":  "",
"bio":  "",
"roleRequest":  {
"roleListName":  ["USER"]
}
}
```
**There are 3 roles: USER, MODERATOR and ADMIN.**

I decided to use JWT to have control over which people access the "platform" and for how long.
In turn, if the generated token is modified, the back end will know that he did not generate it and thus deny access.


# In the User service you can do:
```java
public interface IUserService {

  // find all
  List<Users> findAll();

  // find by id
  Users findById(Long id);

  // find followers
  List<IMyFollowers> findFollowers(Long id);

  // save
  void save(Users user);

  // update
  void update(UserUpdate user);

  // delete
  void deleteById(Long id);
}
```

# In the Post service you can do:
``` java
public interface IPostService {

  // find all
  List<ListAll> findAll();

  // find by id
  Optional<Post> findById(Long id);

  // save
  void save(Post post);

  // update
  void update(PostUpdate post);

  // delete by id
  void delete(Long id);
}
```

# In the Like service you can do:
``` java
public interface ILikeService {

  void save(Likes like);

  void deleteById(Long id);

  void deleteLike(Long postId, Long UserId);
}
```
# Controllers
Knowing what each entity can do these are the end points that are available:

## USERS
```http
GET http://localhost:8080/users -> list all users

GET http://localhost:8080/users/{id} -> Lists the user given the id

GET http://localhost:8080/users/{id}/followers -> Lists the user's followers

PUT http://localhost:8080/users/{id} -> Update a user
{
	"email":  "",
	"username":  "",
	"fullName": "",
	"bio":  ""
	"password": ""
 }
 Each of these fields are optional

DELETE /users/{id} -> Delete a user given the id

POST http://localhost:8080/users/{id}/followers/{followerId} -> Follow a user

DELETE http://localhost:8080/users/{id}/unfollowed/{followerId} -> Unfollow a user (id -> person I unfollowed followerId -> my id)
{
	"followerId":  n,
	"followeeId":  x
}
```

## Post and Comments

```http
GET http://localhost:8080/posts/all -> you get all publications

GET http://localhost:8080/posts/{id} -> You get a publication by id

POST http://localhost:8080/posts -> the image is optional Save Post/publication
{
	"userId":  1,
	"content":  "",
	"imageUrl":  "https://..."
}

PUT http://localhost:8080/posts/{postId}/{userId} -> Update post
{
	"content":  "",
	"imageUrl":  "https://..."
}

POST http://localhost:8080/posts/{postId}/{userId}/comments -> add a comment to a post
{
"content":  ""
}

DELETE http://localhost:8080/posts/{id} -> delete post by id

DELETE http://localhost:8080/posts/{postId}/{userId}/comments/{commentId} -> delete comment by postId and UserId
```

## Like

```http
POST http://localhost:8080/like/{postId}/post/{userId}/user -> like to a post

DELETE http://localhost:8080/like/{postId}/post/{userId}/user -> remove a like from a post
```

## Details to consider
Although there are 5 entities, only 3 controllers are shown since Post and Comments were combined in one (PostController) and Users with Followers (UsersController).

Remember that every http request must have a valid token.

If you want to test this api I will leave you a sql file so you have default data

# Docker
To run this project you have to have docker and docker-compose, be in the root of the project and run this command:
```docker
docker-compose up --build -d
```

If it is done in linux the command would be:
```docker
sudo docker-compose up --build -d
```
