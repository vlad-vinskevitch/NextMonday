package com.sharkit.nextmonday.main_menu.calculator.domain.nutrition;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FoodNutrition implements Serializable {

    private Protein protein;
    private Carbohydrate carbohydrate;
    private Fat fat;
    private Integer calorie;
    private Float cellulose;
    private Float water;
    private Float salt;
    private Float calcium;
    private Float potassium;

    protected void calculateByPortion(final Integer portion) {
        final float coefficient  = 100f / portion;

        this.protein.calculateByPortion(portion);
        this.carbohydrate.calculateByPortion(portion);
        this.fat.calculateByPortion(portion);
        this.calorie = (int) (coefficient * this.calorie);
        this.cellulose = coefficient * this.cellulose;
        this.water = coefficient * this.water;
        this.salt = coefficient * this.salt;
        this.potassium = coefficient * this.potassium;
    }


}
