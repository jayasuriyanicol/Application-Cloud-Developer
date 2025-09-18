const PostList = ({posts}) => {


  return (
    <div>

        <h1>Lista dei Post</h1>

        {posts.map((post,indicePost) => (

            <div key ={indicePost}>
             <h2>{post.titolo}</h2>
             <p>{post.contenuto}</p>
             </div>
             
        ))}
    </div>
  );
};

export default PostList;