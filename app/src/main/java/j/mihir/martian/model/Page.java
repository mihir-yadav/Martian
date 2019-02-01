package j.mihir.martian.model;

public class Page {
    private int ImageId;
    private int textId;
    private choice choice1;
    private choice choice2;
    private boolean IsFinalPage =false;

    public Page(int imageId, int textId) {
        ImageId = imageId;
        this.textId = textId;
        this.IsFinalPage=true;
    }

    public Page(int imageId, int textId, choice choice1, choice choice2) {
        ImageId = imageId;
        this.textId = textId;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public boolean isFinalPage() {
        return IsFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        IsFinalPage = finalPage;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public choice getChoice1() {
        return choice1;
    }

    public void setChoice1(choice choice1) {
        this.choice1 = choice1;
    }

    public choice getChoice2() {
        return choice2;
    }

    public void setChoice2(choice choice2) {
        this.choice2 = choice2;
    }
}
