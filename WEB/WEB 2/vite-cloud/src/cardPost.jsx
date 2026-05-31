import { useEffect, useState } from "react";

const CardPost = () => {
    const url = "https://jsonplaceholder.typicode.com/posts/1";
    const urlUsers = "https://jsonplaceholder.typicode.com/users/";
    const urlCommenti = "https://jsonplaceholder.typicode.com/comments"; //?postId=1

    const [post, setPost] = useState(null);
    const [user, setUser] = useState(null);
    const [commenti, setCommenti] = useState([]);

    useEffect(() => {
        fetch(url)
            .then((resp) => resp.json())
            .then((post) => {
                //codice consumatore ed è sempre dentro una then, consuma il risultato di una promise
                console.log("postsss", post);
                setPost(post);
                const userP = fetch(urlUsers + post.userId).then((resp) => resp.json());
                const commentiP = fetch(urlCommenti + "?postId=" + post.id).then(
                    (resp) => resp.json()
                );

                Promise.all([userP, commentiP]).then((result) => {
                    setUser(result[0]);
                    setCommenti(result[1]);
                });
            });
    }, []);

    if (!post || !user || !commenti) {
        return <div className="cardPost">Caricamento...</div>;
        // Puoi anche usare un componente di "spinner" o solo "null" se non vuoi mostrare nulla
    }
    return (
        <div className="cardPost">
            <h2>{post.title}</h2>
            <p>{post.body}</p>
            <small>{user.name}</small>
            <ul>
                {commenti.map((c) => (
                    <li key={c.id}>{c.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default CardPost;