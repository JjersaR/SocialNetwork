-- 11 users and password JjersaR5649
INSERT INTO SocialNetwork.Users
(account_no_expired, account_no_locked, createdAt, credential_no_expired, is_enabled, email, username, fullName, bio, password)
VALUES(1, 1, '2024-07-09', 1, 1, 'jersa@gmail.com', 'jersa', 'John Smith Brown', 'Learning Spring Boot', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'alice@gmail.com', 'alice', 'Alice Johnson', 'Passionate about Java', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'bob@gmail.com', 'bob', 'Bob Williams', 'Spring Boot enthusiast', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'carol@gmail.com', 'carol', 'Carol Davis', 'Full stack developer', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'dave@gmail.com', 'dave', 'Dave Wilson', 'Microservices architect', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'eve@gmail.com', 'eve', 'Eve Miller', 'Database expert', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'frank@gmail.com', 'frank', 'Frank Moore', 'API developer', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'grace@gmail.com', 'grace', 'Grace Taylor', 'UI/UX designer', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'henry@gmail.com', 'henry', 'Henry Anderson', 'DevOps engineer', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'irene@gmail.com', 'irene', 'Irene Thomas', 'Security specialist', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa'),
(1, 1, '2024-07-09', 1, 1, 'jack@gmail.com', 'jack', 'Jack Harris', 'Machine learning expert', '$2a$10$L17iV.CYKxr40lqV57YyCeXJ6Wy657vYto.MXV0TSPKNIj7ZX4QSa');

INSERT INTO SocialNetwork.Roles
(name)
VALUES('ADMIN'), ('MODERATOR'), ('USER');

INSERT INTO SocialNetwork.Permits
(name)
VALUES('BAN'), ('COMMENT'), ('CREATE'), ('DELETE'), ('EDIT'), ('FOLLOW'), ('LIKE'), ('MANAGE'), ('UNFOLLOW'), ('UPDATE'), ('VIEW');

INSERT INTO SocialNetwork.roles_permits
(Permit_ID, Rol_ID)
VALUES(1, 1),(2, 1),(3, 1),(4, 1),(5, 1),(6, 1),(7, 1),(8, 1),(9, 1),(10, 1),(11, 1),
(11,3),(3,3),(5,3),(4,3),(2,3),(7,3),(6,3),(9,3),(10,3),
(11,2),(3,2),(5,2),(4,2),(2,2),(7,2),(6,2),(9,2),(10,2),(1,2);

INSERT INTO SocialNetwork.users_roles
(Rol_ID, User_ID)
VALUES(1, 1), (2, 1), (3, 1),
(1, 2), (2, 2), (3, 2),
(1, 3), (2, 3),
(2, 4), (3, 4),
(1, 5), (3, 5),
(1, 6), (2, 6), (3, 6),
(1, 7),
(2, 8), (3, 8),
(1, 9), (3, 9),
(2, 10),
(1, 11), (2, 11);


INSERT INTO SocialNetwork.Followers
(createdAt, followee_id, follower_id)
VALUES 
('2024-07-09', 2, 1), 
('2024-07-09', 3, 1), 
('2024-07-09', 4, 2), 
('2024-07-09', 5, 2), 
('2024-07-09', 6, 3), 
('2024-07-09', 7, 3), 
('2024-07-09', 8, 4), 
('2024-07-09', 9, 5), 
('2024-07-09', 10, 6), 
('2024-07-09', 11, 7), 
('2024-07-09', 1, 8), 
('2024-07-09', 3, 9), 
('2024-07-09', 5, 10), 
('2024-07-09', 7, 11), 
('2024-07-09', 2, 9),
('2024-07-09', 4, 10), 
('2024-07-09', 6, 11);


-- 33 post
INSERT INTO SocialNetwork.Post
(createdAt, updatedAt, user_id, content, imageUrl)
VALUES
('2024-07-15', '2024-07-20', 1, 'Having a great day!', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-25', 2, 'Just finished a fantastic book!', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-18', 3, 'Loving the new workout routine!', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-22', 4, 'Exploring new recipes today.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-17', 5, 'Sunny day at the beach.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-19', 6, 'Catching up on some work.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-21', 7, 'Family time is the best time.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-23', 8, 'Trying out a new hobby!', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-24', 9, 'Feeling grateful for today.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-26', 10, 'New adventures await!', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-27', 11, 'Cherishing every moment.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-16', 1, 'Enjoying a quiet evening with a good book.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-20', 2, 'Had an amazing dinner with friends tonight.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-18', 3, 'Excited for the weekend plans!', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-21', 4, 'Just finished a great run this morning.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-22', 5, 'Learning something new every day.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-23', 6, 'Spent the afternoon painting.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-24', 7, 'Had a productive day at work.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-25', 8, 'Loved the weather today, so perfect.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-26', 9, 'Weekend getaway was amazing!', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-27', 10, 'Feeling inspired by the new project.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-28', 11, 'Enjoyed a lovely walk in the park.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-29', 1, 'Had a great time catching up with an old friend.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-30', 2, 'Just finished watching an amazing movie.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-17', 3, 'Started a new book today.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-19', 4, 'Cooked a delicious meal for dinner.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-21', 5, 'Spent the day exploring new places.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-23', 6, 'Attended a wonderful concert tonight.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-25', 7, 'Had a relaxing spa day.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-27', 8, 'Enjoying some quality family time.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-29', 9, 'Feeling grateful for all the good things in life.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-30', 10, 'Had an interesting conversation today.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png'),
('2024-07-15', '2024-07-16', 11, 'Completed a challenging task at work.', 'https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png');

INSERT INTO SocialNetwork.Likes (createdAt, post_id, user_id) VALUES 
(CURRENT_TIMESTAMP, 1, 1), 
(CURRENT_TIMESTAMP, 2, 2),
(CURRENT_TIMESTAMP, 10, 10), 
(CURRENT_TIMESTAMP, 11, 11), 
(CURRENT_TIMESTAMP, 12, 1), 
(CURRENT_TIMESTAMP, 13, 2),
(CURRENT_TIMESTAMP, 14, 3), 
(CURRENT_TIMESTAMP, 15, 4), 
(CURRENT_TIMESTAMP, 16, 5), 
(CURRENT_TIMESTAMP, 17, 6), 
(CURRENT_TIMESTAMP, 18, 7), 
(CURRENT_TIMESTAMP, 19, 8), 
(CURRENT_TIMESTAMP, 20, 9), 
(CURRENT_TIMESTAMP, 21, 10), 
(CURRENT_TIMESTAMP, 22, 11);
(CURRENT_TIMESTAMP, 5, 6), 
(CURRENT_TIMESTAMP, 6, 7), 
(CURRENT_TIMESTAMP, 7, 8), 
(CURRENT_TIMESTAMP, 8, 9), 
(CURRENT_TIMESTAMP, 9, 10), 
(CURRENT_TIMESTAMP, 10, 11), 
(CURRENT_TIMESTAMP, 11, 1), 
(CURRENT_TIMESTAMP, 12, 2), 
(CURRENT_TIMESTAMP, 13, 3), 
(CURRENT_TIMESTAMP, 14, 4), 
(CURRENT_TIMESTAMP, 15, 5), 
(CURRENT_TIMESTAMP, 16, 6);
(CURRENT_TIMESTAMP, 17, 7), 
(CURRENT_TIMESTAMP, 18, 8), 
(CURRENT_TIMESTAMP, 19, 9), 
(CURRENT_TIMESTAMP, 20, 10), 
(CURRENT_TIMESTAMP, 21, 11), 
(CURRENT_TIMESTAMP, 22, 1), 
(CURRENT_TIMESTAMP, 23, 2), 
(CURRENT_TIMESTAMP, 24, 3), 
(CURRENT_TIMESTAMP, 25, 4), 
(CURRENT_TIMESTAMP, 26, 5), 
(CURRENT_TIMESTAMP, 27, 6), 
(CURRENT_TIMESTAMP, 28, 7), 
(CURRENT_TIMESTAMP, 29, 8), 
(CURRENT_TIMESTAMP, 30, 9), 
(CURRENT_TIMESTAMP, 31, 10), 
(CURRENT_TIMESTAMP, 32, 11),
(CURRENT_TIMESTAMP, 33, 1), 
(CURRENT_TIMESTAMP, 1, 3), 
(CURRENT_TIMESTAMP, 2, 4), 
(CURRENT_TIMESTAMP, 4, 6), 
(CURRENT_TIMESTAMP, 5, 7), 
(CURRENT_TIMESTAMP, 6, 8), 
(CURRENT_TIMESTAMP, 7, 9), 
(CURRENT_TIMESTAMP, 8, 10), 
(CURRENT_TIMESTAMP, 9, 11),
(CURRENT_TIMESTAMP, 10, 1), 
(CURRENT_TIMESTAMP, 11, 2), 
(CURRENT_TIMESTAMP, 12, 3), 
(CURRENT_TIMESTAMP, 13, 4), 
(CURRENT_TIMESTAMP, 14, 5), 
(CURRENT_TIMESTAMP, 15, 6), 
(CURRENT_TIMESTAMP, 16, 7), 
(CURRENT_TIMESTAMP, 17, 8),
(CURRENT_TIMESTAMP, 18, 9), 
(CURRENT_TIMESTAMP, 19, 10), 
(CURRENT_TIMESTAMP, 20, 11), 
(CURRENT_TIMESTAMP, 21, 1), 
(CURRENT_TIMESTAMP, 22, 2), 
(CURRENT_TIMESTAMP, 23, 3), 
(CURRENT_TIMESTAMP, 24, 4), 
(CURRENT_TIMESTAMP, 25, 5), 
(CURRENT_TIMESTAMP, 26, 6), 
(CURRENT_TIMESTAMP, 27, 7), 
(CURRENT_TIMESTAMP, 28, 8), 
(CURRENT_TIMESTAMP, 29, 9), 
(CURRENT_TIMESTAMP, 30, 10), 
(CURRENT_TIMESTAMP, 31, 11), 
(CURRENT_TIMESTAMP, 32, 1), 
(CURRENT_TIMESTAMP, 33, 2);

INSERT INTO SocialNetwork.Comments (createdAt, updatedAt, post_id, user_id, content) VALUES
('2024-07-15', '2024-07-20', 1, 2, 'Great post!'),
('2024-07-15', '2024-07-18', 2, 3, 'Interesting read.'),
('2024-07-15', '2024-07-22', 3, 4, 'Thanks for sharing!'),
('2024-07-15', '2024-07-25', 4, 5, 'Loved this!'),
('2024-07-15', '2024-07-27', 5, 6, 'Very informative.'),
('2024-07-15', '2024-07-19', 6, 7, 'Nice picture!'),
('2024-07-15', '2024-07-23', 7, 8, 'Well written.');

INSERT INTO SocialNetwork.Comments (createdAt, updatedAt, post_id, user_id, content) VALUES
('2024-07-15', '2024-07-21', 8, 9, 'This is amazing!'),
('2024-07-15', '2024-07-17', 9, 10, 'Great insights.'),
('2024-07-15', '2024-07-26', 10, 11, 'I totally agree.'),
('2024-07-15', '2024-07-24', 11, 1, 'Fantastic!'),
('2024-07-15', '2024-07-28', 12, 2, 'Awesome post!'),
('2024-07-15', '2024-07-29', 13, 3, 'Very helpful.'),
('2024-07-15', '2024-07-16', 14, 4, 'Good job!'),
('2024-07-15', '2024-07-27', 15, 5, 'I learned a lot.'),
('2024-07-15', '2024-07-18', 16, 6, 'Nice content!'),
('2024-07-15', '2024-07-20', 17, 7, 'Very interesting.'),
('2024-07-15', '2024-07-21', 18, 8, 'Keep it up!'),
('2024-07-15', '2024-07-23', 19, 9, 'Well done!');

INSERT INTO SocialNetwork.Comments (createdAt, updatedAt, post_id, user_id, content) VALUES
('2024-07-15', '2024-07-22', 20, 10, 'Excellent!'),
('2024-07-15', '2024-07-19', 21, 11, 'Brilliant!'),
('2024-07-15', '2024-07-24', 22, 1, 'Superb!'),
('2024-07-15', '2024-07-25', 23, 2, 'Loved it!'),
('2024-07-15', '2024-07-28', 24, 3, 'Thanks for this!'),
('2024-07-15', '2024-07-26', 25, 4, 'Great advice.'),
('2024-07-15', '2024-07-17', 26, 5, 'Incredible post!'),
('2024-07-15', '2024-07-29', 27, 6, 'Nicely written.'),
('2024-07-15', '2024-07-16', 28, 7, 'Very nice!');

INSERT INTO SocialNetwork.Comments (createdAt, updatedAt, post_id, user_id, content) VALUES
('2024-07-15', '2024-07-27', 29, 8, 'Thank you!'),
('2024-07-15', '2024-07-20', 30, 9, 'Awesome!'),
('2024-07-15', '2024-07-18', 31, 10, 'Great stuff.'),
('2024-07-15', '2024-07-22', 32, 11, 'Very good post.'),
('2024-07-15', '2024-07-23', 33, 1, 'Loved this content.'),
('2024-07-15', '2024-07-20', 1, 2, 'Great post!'),
('2024-07-15', '2024-07-18', 1, 3, 'Interesting read.'),
('2024-07-15', '2024-07-22', 1, 4, 'Thanks for sharing!'),
('2024-07-15', '2024-07-25', 2, 5, 'Loved this!'),
('2024-07-15', '2024-07-27', 2, 6, 'Very informative.');

INSERT INTO SocialNetwork.Comments (createdAt, updatedAt, post_id, user_id, content) VALUES
('2024-07-15', '2024-07-24', 4, 1, 'Fantastic!'),
('2024-07-15', '2024-07-28', 4, 2, 'Awesome post!'),
('2024-07-15', '2024-07-29', 5, 3, 'Very helpful.'),
('2024-07-15', '2024-07-16', 5, 4, 'Good job!'),
('2024-07-15', '2024-07-27', 5, 5, 'I learned a lot.'),
('2024-07-15', '2024-07-18', 6, 6, 'Nice content!'),
('2024-07-15', '2024-07-20', 6, 7, 'Very interesting.'),
('2024-07-15', '2024-07-21', 6, 8, 'Keep it up!'),
('2024-07-15', '2024-07-23', 7, 9, 'Well done!'),
('2024-07-15', '2024-07-22', 7, 10, 'Excellent!'),
('2024-07-15', '2024-07-19', 7, 11, 'Brilliant!');

INSERT INTO SocialNetwork.Comments (createdAt, updatedAt, post_id, user_id, content) VALUES
('2024-07-15', '2024-07-24', 8, 1, 'Superb!'),
('2024-07-15', '2024-07-25', 8, 2, 'Loved it!'),
('2024-07-15', '2024-07-28', 8, 3, 'Thanks for this!'),
('2024-07-15', '2024-07-26', 9, 4, 'Great advice.'),
('2024-07-15', '2024-07-17', 9, 5, 'Incredible post!'),
('2024-07-15', '2024-07-29', 9, 6, 'Nicely written.'),
('2024-07-15', '2024-07-16', 10, 7, 'Very nice!'),
('2024-07-15', '2024-07-27', 10, 8, 'Thank you!'),
('2024-07-15', '2024-07-20', 10, 9, 'Awesome!');

INSERT INTO SocialNetwork.Comments (createdAt, updatedAt, post_id, user_id, content) VALUES
('2024-07-15', '2024-07-18', 11, 10, 'Great stuff.'),
('2024-07-15', '2024-07-22', 11, 11, 'Very good post.'),
('2024-07-15', '2024-07-23', 11, 1, 'Loved this content.'),
('2024-07-15', '2024-07-25', 12, 2, 'Great insights again!'),
('2024-07-15', '2024-07-29', 12, 3, 'Another interesting read.'),
('2024-07-15', '2024-07-28', 12, 4, 'Thanks for the update!'),
('2024-07-15', '2024-07-20', 13, 5, 'Loved this one too!'),
('2024-07-15', '2024-07-27', 13, 6, 'Very informative again.'),
('2024-07-15', '2024-07-19', 13, 7, 'Nice picture once more!'),
('2024-07-15', '2024-07-21', 14, 8, 'Well written again.'),
('2024-07-15', '2024-07-23', 14, 9, 'This is still amazing!');

INSERT INTO SocialNetwork.Comments (createdAt, updatedAt, post_id, user_id, content) VALUES
('2024-07-15', '2024-07-18', 14, 10, 'Great insights once again.'),
('2024-07-15', '2024-07-22', 15, 11, 'I totally agree with this!'),
('2024-07-15', '2024-07-26', 15, 1, 'Fantastic post!'),
('2024-07-15', '2024-07-24', 15, 2, 'Awesome post once more!'),
('2024-07-15', '2024-07-29', 16, 3, 'Very helpful indeed.'),
('2024-07-15', '2024-07-16', 16, 4, 'Good job on this one!'),
('2024-07-15', '2024-07-27', 16, 5, 'I learned a lot from this.'),
('2024-07-15', '2024-07-18', 17, 6, 'Nice content again!'),
('2024-07-15', '2024-07-20', 17, 7, 'Very interesting post.'),
('2024-07-15', '2024-07-21', 17, 8, 'Keep it up with these!'),
('2024-07-15', '2024-07-23', 18, 9, 'Well done again!'),
('2024-07-15', '2024-07-22', 18, 10, 'Excellent post!'),
('2024-07-15', '2024-07-19', 18, 11, 'Brilliant work!'),
('2024-07-15', '2024-07-24', 19, 1, 'Superb content!'),
('2024-07-15', '2024-07-25', 19, 2, 'Loved this post!');

INSERT INTO SocialNetwork.Comments (createdAt, updatedAt, post_id, user_id, content) VALUES
('2024-07-15', '2024-07-28', 19, 3, 'Thanks for this content!'),
('2024-07-15', '2024-07-26', 20, 4, 'Great advice here.'),
('2024-07-15', '2024-07-17', 20, 5, 'Incredible post once more!'),
('2024-07-15', '2024-07-29', 20, 6, 'Nicely written content.'),
('2024-07-15', '2024-07-16', 21, 7, 'Very nice post!'),
('2024-07-15', '2024-07-27', 21, 8, 'Thank you for this!'),
('2024-07-15', '2024-07-20', 21, 9, 'Awesome content!'),
('2024-07-15', '2024-07-18', 22, 10, 'Great stuff here.'),
('2024-07-15', '2024-07-22', 22, 11, 'Very good post here.'),
('2024-07-15', '2024-07-23', 22, 1, 'Loved this content a lot.'),
('2024-07-15', '2024-07-25', 23, 2, 'Great insights again!'),
('2024-07-15', '2024-07-29', 23, 3, 'Another interesting read here.'),
('2024-07-15', '2024-07-28', 23, 4, 'Thanks for the update here!'),
('2024-07-15', '2024-07-20', 24, 5, 'Loved this one as well!'),
('2024-07-15', '2024-07-27', 24, 6, 'Very informative content.');








