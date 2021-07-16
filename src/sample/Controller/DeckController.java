package sample.Controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.util.Duration;
import java.util.ArrayList;

public class DeckController {

    private final SceneLoader sceneLoader = new SceneLoader();
    Image card = new Image("kart.png");

    @FXML
    private Label goBackLabel;
    @FXML
    private ImageView slot1;
    @FXML
    private ImageView slot2;
    @FXML
    private ImageView slot3;
    @FXML
    private ImageView slot4;
    @FXML
    private ImageView slot5;
    @FXML
    private ImageView slot6;
    @FXML
    private ImageView slot7;
    @FXML
    private ImageView slot8;

    private boolean slot1IsUsed = false;
    private boolean slot2IsUsed = false;
    private boolean slot3IsUsed = false;
    private boolean slot4IsUsed = false;
    private boolean slot5IsUsed = false;
    private boolean slot6IsUsed = false;
    private boolean slot7IsUsed = false;
    private boolean slot8IsUsed = false;

    private boolean img1IsUsed = false;
    private boolean img2IsUsed = false;
    private boolean img3IsUsed = false;
    private boolean img4IsUsed = false;
    private boolean img5IsUsed = false;
    private boolean img6IsUsed = false;
    private boolean img7IsUsed = false;
    private boolean img8IsUsed = false;
    private boolean img9IsUsed = false;
    private boolean img10IsUsed = false;
    private boolean img11IsUsed = false;
    private boolean img12IsUsed = false;

    ArrayList<ImageView> slots = new ArrayList<>();

    private void addToSlots() {
        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        slots.add(slot4);
        slots.add(slot5);
        slots.add(slot6);
        slots.add(slot7);
        slots.add(slot8);
    }

    private void checkSlot(Image img) {
        addToSlots();
        if (!slot1IsUsed) {
            slot1.setImage(img);
            slot1IsUsed = true;
        } else if (!slot2IsUsed) {
            slot2.setImage(img);
            slot2IsUsed = true;
        } else if (!slot3IsUsed) {
            slot3.setImage(img);
            slot3IsUsed = true;
        } else if (!slot4IsUsed) {
            slot4.setImage(img);
            slot4IsUsed = true;
        } else if (!slot5IsUsed) {
            slot5.setImage(img);
            slot5IsUsed = true;
        } else if (!slot6IsUsed) {
            slot6.setImage(img);
            slot6IsUsed = true;
        } else if (!slot7IsUsed) {
            slot7.setImage(img);
            slot7IsUsed = true;
        } else if (!slot8IsUsed) {
            slot8.setImage(img);
            slot8IsUsed = true;
        }
    }

    private void checkEmptySlots(Image img) {
        for (ImageView slot : slots) {
            if (slot.getImage().getUrl().equals(img.getUrl())) {
                if (slot.equals(slot1))
                    slot1IsUsed = false;
                if (slot.equals(slot2))
                    slot2IsUsed = false;
                if (slot.equals(slot3))
                    slot3IsUsed = false;
                if (slot.equals(slot4))
                    slot4IsUsed = false;
                if (slot.equals(slot5))
                    slot5IsUsed = false;
                if (slot.equals(slot6))
                    slot6IsUsed = false;
                if (slot.equals(slot7))
                    slot7IsUsed = false;
                if (slot.equals(slot8))
                    slot8IsUsed = false;
            }
        }
    }

    private void removeCard(Image image){
        for (ImageView slot : slots) {
            if (slot.getImage().getUrl().equals(image.getUrl())) {
                checkEmptySlots(image);
                slot.setImage(card);
            }
        }
    }

    @FXML
    public void imageClick1(MouseEvent event) {
        Image image = new Image("giant_00000.png");
        if (!img1IsUsed) {
            checkSlot(image);
            img1IsUsed = true;
        } else {
            img1IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick2(MouseEvent event) {
        Image image = new Image("inferno_00000.png");
        if (!img2IsUsed) {
            checkSlot(image);
            img2IsUsed = true;
        } else {
            img2IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick3(MouseEvent event) {
        Image image = new Image("mini pekka_00000.png");
        if (!img3IsUsed) {
            checkSlot(image);
            img3IsUsed = true;
        } else {
            img3IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick4(MouseEvent event) {
        Image image = new Image("rage_00000.png");
        if (!img4IsUsed) {
            checkSlot(image);
            img4IsUsed = true;
        } else {
            img4IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick5(MouseEvent event) {
        Image image = new Image("valkyrie_00000.png");
        if (!img5IsUsed) {
            checkSlot(image);
            img5IsUsed = true;
        } else {
            img5IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick6(MouseEvent event) {
        Image image = new Image("wizard_00000.png");
        if (!img6IsUsed) {
            checkSlot(image);
            img6IsUsed = true;
        } else {
            img6IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick7(MouseEvent event) {
        Image image = new Image("archer_00000.png");
        if (!img7IsUsed) {
            checkSlot(image);
            img7IsUsed = true;
        } else {
            img7IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick8(MouseEvent event) {
        Image image = new Image("arrows_00000.png");
        if (!img8IsUsed) {
            checkSlot(image);
            img8IsUsed = true;
        } else {
            img8IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick9(MouseEvent event) {
        Image image = new Image("barbarian_00000.png");
        if (!img9IsUsed) {
            checkSlot(image);
            img9IsUsed = true;
        } else {
            img9IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick10(MouseEvent event) {
        Image image = new Image("baby dragon_00000.png");
        if (!img10IsUsed) {
            checkSlot(image);
            img10IsUsed = true;
        } else {
            img10IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick11(MouseEvent event) {
        Image image = new Image("canon_00000.png");
        if (!img11IsUsed) {
            checkSlot(image);
            img11IsUsed = true;
        } else {
            img11IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    public void imageClick12(MouseEvent event) {
        Image image = new Image("fireball_00000.png");
        if (!img12IsUsed) {
            checkSlot(image);
            img12IsUsed = true;
        } else {
            img12IsUsed = false;
            removeCard(image);
        }
    }

    @FXML
    void goToMenu(MouseEvent event) {
        sceneLoader.goToMainMenu(event);
    }

    @FXML
    void backHover(MouseEvent event) {
        fadeIn(goBackLabel);
    }

    @FXML
    void backUnHover(MouseEvent event) {
        fadeOut(goBackLabel);
    }

    void fadeIn(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.65),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(1);
        ft.play();
    }
    void fadeOut(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.65),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(0);
        ft.play();
    }

}