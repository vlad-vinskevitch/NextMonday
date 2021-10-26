package com.sharkit.nextmonday.db.firestore.calculator;

import static com.sharkit.nextmonday.configuration.constant.FirebaseCollection.MODERATION_FOOD;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sharkit.nextmonday.entity.calculator.FoodInfo;

public class FoodInfoFirebase {
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void create(FoodInfo foodInfo) {
        db.collection(MODERATION_FOOD)
                .document(foodInfo.getId())
                .set(foodInfo);
    }

    public Task<DocumentSnapshot> findFoodById(String id) {
        return db.collection(MODERATION_FOOD)
                .document(id)
                .get();
    }
}