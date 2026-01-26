import React, { useEffect } from 'react'
import { useState } from 'react';



const PostGrid = () => {


    const URL_POSTS = " https://jsonplaceholder.typicode.com/posts";
    const URL_USERS = " https://jsonplaceholder.typicode.com/users";
    const URL_COMMENTS = " https://jsonplaceholder.typicode.com/comments";
    const[posts,setPosts]  = useState ([]);


    async function fecthPostDetail(post){

        try{

ostI            const userP=fetch(URL_USERS+post.userId).then(resp => resp.json())
            const commentsP=fetch(URL_USERS+"?pd="+post.id).then(resp => resp.json())
            const[user,commenti] = await Promise.all([userP, commentsP] ) 
            return{

                ...post,
                user:user.username,
                commenti:commenti

            }
        } catch(err){

        console.log("Attenzione errore " + err)
        return{...post,user:"Sconosciuto", commenti:+[]}  
    }
}
    useEffect(() =>{

        fetch(URL_POSTS).then(response => response.json()).then(allPosts =>{
            
            //Creation an array of promise
            const postArricchitiPromise = allPosts.map(fecthPostDetail);

            //Consumiamo il tutto con una promise all
            Promise.all(postArricchitiPromise).then(allPostsArricchiti => setPosts(allPostsArricchiti));

    
        });
    
   },[]);

  return (
    <div>
      {posts.map((p) => (
        <div><p>{p.title}</p>
         <p>Nome {p.user}</p>
         </div>
      ))}
    </div>
  );
};

export default PostGrid;




{ /* Import React, { useEffect, useState } from "react";

const PostGrid = () => {
  const URL_POSTS = "https://jsonplaceholder.typicode.com/posts";
  const URL_USERS = "https://jsonplaceholder.typicode.com/users/";
  const URL_COMMENTS = "https://jsonplaceholder.typicode.com/comments";
  const [posts, setPosts] = useState([]);

async function fetchPostDetails(post) {
  try {
    const userPromise = fetch(URL_USERS + post.userId).then(resp => resp.json());
    const commentsPromise = fetch(URL_COMMENTS + "?postId=" + post.id).then(resp => resp.json());

    const [user, comments] = await Promise.all([userPromise, commentsPromise]);

    return {
      ...post,
      user: user.name, 
     
      comments: comments//.slice(0, 5) 
    };
  } catch (error) {
    console.error(`Errore nel caricamento dettagli post ${post.id}:`, error);
    return { ...post, user: 'Sconosciuto', comments: [] };
  }
}
  useEffect(() => {
    fetch(URL_POSTS)
      .then((response) => response.json())
      .then((allPosts) => {

        const postsArricchitiPromise=allPosts.map(fetchPostDetails)
        console.log(postsArricchitiPromise)
        Promise.all(postsArricchitiPromise).then(allPostsArricchiti=>setPosts(allPostsArricchiti))
        


      });
  }, []);
  return (
    <div>
      {posts.map((p) => (
        <div><p>{p.title}</p>
         <p>Nome {p.user}</p>
         </div>
      ))}
    </div>
  );
};

export default PostGrid;
y*/}