package net.runelite.client.plugins.JakEssenceMiner;

import com.openosrs.client.ui.overlay.components.table.TableAlignment;
import com.openosrs.client.ui.overlay.components.table.TableComponent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.ColorUtil;


import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import static org.apache.commons.lang3.time.DurationFormatUtils.formatDuration;

@Slf4j
@Singleton
class JakEssenceMinerOverlay extends OverlayPanel {

    private final JakEssenceMinerPlugin plugin;
    private final JakEssenceMinerConfig config;

    String timeFormat;
    private String infoStatus = "Starting...";

    @Inject
    private JakEssenceMinerOverlay(final JakEssenceMinerPlugin plugin, final JakEssenceMinerConfig config) {
        super(plugin);
        setPosition(OverlayPosition.BOTTOM_LEFT);
        this.plugin = plugin;
        this.config = config;
        getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Template overlay"));
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (plugin.botTimer == null ) {
            return null;
        }
        TableComponent tableComponent = new TableComponent();
        tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);


        Duration duration = Duration.between(plugin.botTimer, Instant.now());
        timeFormat = (duration.toHours() < 1) ? "mm:ss" : "HH:mm:ss";
        tableComponent.addRow("Time running:", formatDuration(duration.toMillis(), timeFormat));

    //    tableComponent.addRow("", "");

        TableComponent tableStatsComponent = new TableComponent();
        tableStatsComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

        if (!tableComponent.isEmpty()) {
            panelComponent.setPreferredSize(new Dimension(140, 100));
            panelComponent.setBorder(new Rectangle(5, 5, 5, 5));
            panelComponent.getChildren().add(TitleComponent.builder()
                    .text("Essence Miner")
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
