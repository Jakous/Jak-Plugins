/*
 * Copyright (c) 2018, Andrew EP | ElPinche256 <https://github.com/ElPinche256>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.jakspicecollector;

import net.runelite.client.config.*;

@ConfigGroup("JakSpiceCollector")

public interface JakSpiceCollectorConfig extends Config
{
	@ConfigTitle(
			keyName = "instructionsTitle",
			name = "Instructions",
			description = "",
			position = 1
	)
	String instructionsTitle = "instructionsTitle";

	@ConfigItem(
			keyName = "read",
			name = "",
			description = "Instructions. Don't enter anything into this field",
			position = 2,
			title = "instructionsTitle"
	)
	default String read() {
		return "Start in Evil Dave's basement near with raw karambwanji in inventory near the behemoth hell rat you want to fight. " +
				"Does not bank, if you want banking checkout Sandy Plugins.";
	}

	@ConfigItem(
			keyName = "type",
			name = "Cat Type",
			description = "Type of cat being used. Choose appropriate cat type from options ",
			position = 3
	)
	default JakSpiceCollectorCatType type() {
		return JakSpiceCollectorCatType.NORMAL;
	}

	@ConfigItem(
			keyName = "enableUI",
			name = "Enable UI",
			description = "Enable if using karambwanji as food for cat during fight.",
			position = 4
	)
	default boolean enableUI()
	{
		return true;
	}

	@ConfigItem(
			keyName = "startSpice",
			name = "Start/Stop",
			description = "Start/stop button",
			position = 5
	)
	default Button startSpice() {
		return new Button();
	}

	@ConfigSection(
			keyName = "delayConfig",
			name = "Sleep Delay Configuration",
			description = "Configure how the bot handles sleep delays",
			closedByDefault = true,
			position = 11
	)
	String delayConfig = "delayConfig";

	@Range(
			min = 0,
			max = 550
	)
	@ConfigItem(
			keyName = "sleepMin",
			name = "Sleep Min",
			description = "",
			position = 12,
			section = "delayConfig"
	)
	default int sleepMin() {
		return 0;
	}

	@Range(
			min = 0,
			max = 550
	)
	@ConfigItem(
			keyName = "sleepMax",
			name = "Sleep Max",
			description = "",
			position = 13,
			section = "delayConfig"
	)
	default int sleepMax() {
		return 0;
	}

	@Range(
			min = 0,
			max = 550
	)
	@ConfigItem(
			keyName = "sleepTarget",
			name = "Sleep Target",
			description = "",
			position = 14,
			section = "delayConfig"
	)
	default int sleepTarget() {
		return 0;
	}

	@Range(
			min = 0,
			max = 550
	)
	@ConfigItem(
			keyName = "sleepDeviation",
			name = "Sleep Deviation",
			description = "",
			position = 15,
			section = "delayConfig"
	)
	default int sleepDeviation() {
		return 10;
	}

	@ConfigItem(
			keyName = "sleepWeightedDistribution",
			name = "Sleep Weighted Distribution",
			description = "Shifts the random distribution towards the lower end at the target, otherwise it will be an even distribution",
			position = 16,
			section = "delayConfig"
	)
	default boolean sleepWeightedDistribution() {
		return false;
	}

	@ConfigSection(
			keyName = "delayTickConfig",
			name = "Tick Delay Configuration",
			description = "Configure how the bot handles game tick delays, 1 game tick equates to roughly 600ms",
			closedByDefault = true,
			position = 17
	)
	String delayTickConfig = "delayTickConfig";

	@Range(
			min = 0,
			max = 4
	)
	@ConfigItem(
			keyName = "tickDelayMin",
			name = "Game Tick Min",
			description = "",
			position = 18,
			section = "delayTickConfig"
	)
	default int tickDelayMin() {
		return 1;
	}

	@Range(
			min = 0,
			max = 4
	)
	@ConfigItem(
			keyName = "tickDelayMax",
			name = "Game Tick Max",
			description = "",
			position = 19,
			section = "delayTickConfig"
	)
	default int tickDelayMax() {
		return 3;
	}

	@Range(
			min = 0,
			max = 4
	)
	@ConfigItem(
			keyName = "tickDelayTarget",
			name = "Game Tick Target",
			description = "",
			position = 20,
			section = "delayTickConfig"
	)
	default int tickDelayTarget() {
		return 2;
	}

	@Range(
			min = 0,
			max = 4
	)
	@ConfigItem(
			keyName = "tickDelayDeviation",
			name = "Game Tick Deviation",
			description = "",
			position = 21,
			section = "delayTickConfig"
	)
	default int tickDelayDeviation() {
		return 1;
	}

	@ConfigItem(
			keyName = "tickDelayWeightedDistribution",
			name = "Game Tick Weighted Distribution",
			description = "Shifts the random distribution towards the lower end at the target, otherwise it will be an even distribution",
			position = 22,
			section = "delayTickConfig"
	)
	default boolean tickDelayWeightedDistribution() {
		return false;
	}
}