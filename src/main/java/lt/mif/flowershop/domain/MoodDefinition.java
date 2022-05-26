package lt.mif.flowershop.domain;

public class MoodDefinition {

    private Occasion occasion;
    private Style style;
    private AgeGroup ageGroup;
    private ColorPalette colorPalette;

    public MoodDefinition() {
    }

    public Occasion getOccasion() {
        return occasion;
    }

    public void setOccasion(Occasion occasion) {
        this.occasion = occasion;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public ColorPalette getColorPalette() {
        return colorPalette;
    }

    public void setColorPalette(ColorPalette colorPalette) {
        this.colorPalette = colorPalette;
    }

    public enum Occasion {
        WEDDING, FUNERAL, BIRTHDAY, CELEBRATION
    }

    public enum Style {
        CONTEMPORARY, CLASSIC, ROMANTIC, MINIMALIST, COSY
    }

    public enum ColorPalette {
        PASTEL, COLORFUL, DEEP, DARK, LIGHT
    }

    public enum AgeGroup {
        ADULT, KID, SENIOR
    }

    @Override
    public String toString() {
        return "MoodDefinition{" +
                "occasion=" + occasion +
                ", style=" + style +
                ", ageGroup=" + ageGroup +
                ", colorPalette=" + colorPalette +
                '}';
    }
}

