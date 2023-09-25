package SpringBoot.firebase.firebaseCrud.service;

import SpringBoot.firebase.firebaseCrud.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.util.concurrent.ExecutionException;

@Service
public class CRUDService {
    
    public String createUser(User user) throws ExecutionException, InterruptedException {
        Firestore firestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> colletectionsApiFuture= (ApiFuture<WriteResult>) firestore.collection("crud_user").document(user.getDocumentId()).set(user);

return  colletectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUser(String document_id) throws ExecutionException, InterruptedException {
        Firestore firestore= FirestoreClient.getFirestore();
        DocumentReference documentReference=firestore.collection("crud_user").document(document_id);
        ApiFuture<DocumentSnapshot> future= documentReference.get();
        DocumentSnapshot document=future.get();
        User user;
        System.out.println(document.toString());
        if(document.exists()){
            System.out.println("user Found");
            user = document.toObject(User.class);
            return user;
        }
        System.out.println("user not Found");
        return null;
    }

    public String updateUser(User user) {
        Firestore firestore=FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=firestore.collection("crud_user").document(user.getDocumentId()).set(user);


        return "successfully updated";
    }

    public String deleteUser(String documentId) {
        Firestore firestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> colletectionsApiFuture= (ApiFuture<WriteResult>) firestore.collection("crud_user").document(documentId).delete();

        return "Successfully Deleted " + documentId;

    }
}
