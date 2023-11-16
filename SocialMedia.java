public class SocialMedia{
    private String currentPost;
    public static int likes = 1;

    public void createPost(String post){
       // SocialMedia smObj = new SocialMedia();
        currentPost = post;
    }
    public static void likePost(){
        likes++;
    }
    public static void main(String[] args){
        SocialMedia user1 = new SocialMedia();
        user1.createPost("My first post on GSU-PAROT, hello!");

        SocialMedia user2 = new SocialMedia();
        user2.createPost("Dawaki, making a post on GSU-PAROT, herry!");
        user2.likePost();

        System.out.println("Current post: "+user2.currentPost);
        System.out.println("Number of likes: "+user1.likes);
    }
}