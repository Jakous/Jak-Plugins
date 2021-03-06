package net.runelite.client.plugins.jaktelealch;

import com.openosrs.client.ui.overlay.components.table.TableAlignment;
import com.openosrs.client.ui.overlay.components.table.TableComponent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.ColorUtil;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;

import static org.apache.commons.lang3.time.DurationFormatUtils.formatDuration;

@Slf4j
@Singleton
class JakTeleAlchOverlay extends OverlayPanel {

    private final JakTeleAlchPlugin plugin;
    private final JakTeleAlchConfig config;

    String timeFormat;
    private String infoStatus = "Starting...";

    @Inject
    private JakTeleAlchOverlay(final JakTeleAlchPlugin plugin, final JakTeleAlchConfig config) {
        super(plugin);
        setPosition(OverlayPosition.BOTTOM_LEFT);
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (plugin.botTimer == null || !config.enableUI()) {
            return null;
        }
        TableComponent tableComponent = new TableComponent();
        tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

        Duration duration = Duration.between(plugin.botTimer, Instant.now());
        timeFormat = (duration.toHours() < 1) ? "mm:ss" : "HH:mm:ss";
        tableComponent.addRow("Time running:", formatDuration(duration.toMillis(), timeFormat));
        tableComponent.addRow("EXP Gained: ", "" + plugin.getGainedMagicEXP());

        TableComponent tableStatsComponent = new TableComponent();
        tableStatsComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

        if (!tableComponent.isEmpty()) {
        //    panelComponent.setBackgroundColor(ColorUtil.fromHex("#121212")); //Material Dark default
            panelComponent.setPreferredSize(new Dimension(160, 140));
            panelComponent.setBorder(new Rectangle(5, 5, 5, 5));
            panelComponent.getChildren().add(TitleComponent.builder()
                    .text("Jak Magic Trainer")
                    .color(ColorUtil.fromHex("#53d4d4"))
                    .build());
            panelComponent.getChildren().add(tableComponent);
            panelComponent.getChildren().add(TitleComponent.builder()
                    .text("Active")
                    .color(ColorUtil.fromHex("#55FF0C"))
                    .build());
            panelComponent.getChildren().add(tableStatsComponent);
        }
        return super.render(graphics);
    }
}
