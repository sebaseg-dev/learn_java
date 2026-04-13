package fr.sebaseg;

import fr.sebaseg.indie.controller.MainController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    @DisplayName("The main program's loop should be correctly initialised")
    void createController_ShouldReturnValidConfiguration() {
        MainController controller = App.createController();

        assertThat(controller).isNotNull();
    }
}
