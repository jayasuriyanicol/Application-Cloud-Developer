import React, { useEffect } from 'react'
import { useState } from 'react';



const PostGrid = () => {


    const URL_POSTS = " https://jsonplaceholder.typicode.com/posts";
    const URL_USERS = " https://jsonplaceholder.typicode.com/users";
    const URL_COMMENTS = " https://jsonplaceholder.typicode.com/comments";
    const[posts,setPosts]  = useState ([]);


    async function fecthPostDetail(post){

        try{

            const userP=fetch(URL_USERS+post.userId).then(reso => resp.json())
            const commentsP=fetch(URL_USERS+"?postId="+post.id).then(reso => resp.json())
            const[user,commenti] = Promise.all([userP, commentsP] ) 
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

       {posts.map(p =>(<p>{p.title}</p>))}


    </div>
  );
};

export default PostGrid;