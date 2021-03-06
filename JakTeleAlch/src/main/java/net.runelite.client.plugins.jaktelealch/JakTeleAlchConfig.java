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
package net.runelite.client.plugins.jaktelealch;

import net.runelite.client.config.*;

@ConfigGroup("JakTeleAlch")

public interface JakTeleAlchConfig extends Config
{
	@ConfigItem(
			keyName = "enableUI",
			name = "Enable UI",
			description = "Enables UI showing runtime + exp gained.",
			position = 90
	)
	default boolean enableUI()
	{
		return true;
	}

	@ConfigItem(
			keyName = "mode",
			name = "Plugin Mode",
			description = "Select the plugin mode",
			position = 91
	)
	default JakTeleAlchMode mode() {
		return JakTeleAlchMode.TELEPORT_ALCH;
	}

	@ConfigItem(
			keyName = "teleport",
			name = "Teleport Spell",
			description = "Type of teleport being used",
			position = 92
	)
	default JakTeleAlchLoc teleport() {
		return JakTeleAlchLoc.LUMBRIDGE;
	}

	@ConfigItem(
			keyName = "stun",
			name = "Debuff Spell",
			description = "Type of debuff spell being used",
			position = 93
	)
	default JakTeleAlchStunSpell stun() {
		return JakTeleAlchStunSpell.STUN;
	}

	@ConfigItem(
			keyName = "NpcID",
			name = "NPC ID",
			description = "ID of NPC to be splash/stunned",
			position = 94
	)
	default int NpcID() { return 420; }

	@ConfigItem(
			keyName = "alchItemID",
			name = "Alch Item ID",
			description = "ID of item to be alched",
			position = 95
	)
	default int alchItemID() { return 420; }

	@ConfigItem(
			keyName = "startTeleAlch",
			name = "Start/Stop",
			description = "Start/stop button",
			position = 96
	)
	default Button startTeleAlch() {
		return new Button();
	}

	@ConfigSection(
			keyName = "delayConfig",
			name = "Delay Configuration",
			description = "Configure how the bot handles sleep delays",
			closedByDefault = true,
			position = 5
	)
	String delayConfig = "delayConfig";


	@Range(
			min = 0,
			max = 500
	)
	@ConfigItem(
			keyName = "sleepMin",
			name = "Sleep Min",
			description = "",
			position = 6,
			section = "delayConfig"
	)
	default int sleepMin() {
		return 100;
	}

	@Range(
			min = 0,
			max = 500
	)
	@ConfigItem(
			keyName = "sleepMax",
			name = "Sleep Max",
			description = "",
			position = 7,
			section = "delayConfig"
	)
	default int sleepMax() {
		return 300;
	}

	@Range(
			min = 0,
			max = 500
	)
	@ConfigItem(
			keyName = "sleepTarget",
			name = "Sleep Target",
			description = "",
			position = 8,
			section = "delayConfig"
	)
	default int sleepTarget() {
		return 200;
	}

	@Range(
			min = 0,
			max = 200
	)
	@ConfigItem(
			keyName = "sleepDeviation",
			name = "Sleep Deviation",
			description = "",
			position = 9,
			section = "delayConfig"
	)
	default int sleepDeviation() {
		return 50;
	}

	@ConfigItem(
			keyName = "sleepWeightedDistribution",
			name = "Sleep Weighted Distribution",
			description = "Shifts the random distribution towards the lower end at the target, otherwise it will be an even distribution",
			position = 10,
			section = "delayConfig"
	)
	default boolean sleepWeightedDistribution() {
		return false;
	}

	@Range(
			min = 0,
			max = 5
	)
	@ConfigItem(
			keyName = "tickDelayMin",
			name = "Game Tick Min",
			description = "",
			position = 12,
			section = "delayConfig"
	)
	default int tickDelayMin() {
		return 1;
	}

	@Range(
			min = 0,
			max = 5
	)
	@ConfigItem(
			keyName = "tickDelayMax",
			name = "Game Tick Max",
			description = "",
			position = 13,
			section = "delayConfig"

	)
	default int tickDelayMax() {
		return 3;
	}

	@Range(
			min = 0,
			max = 5
	)
	@ConfigItem(
			keyName = "tickDelayTarget",
			name = "Game Tick Target",
			description = "",
			position = 14,
			section = "delayConfig"
	)
	default int tickDelayTarget() {
		return 2;
	}

	@Range(
			min = 0,
			max = 5
	)
	@ConfigItem(
			keyName = "tickDelayDeviation",
			name = "Game Tick Deviation",
			description = "",
			position = 15,
			section = "delayConfig"
	)
	default int tickDelayDeviation() {
		return 1;
	}

	@ConfigItem(
			keyName = "tickDelayWeightedDistribution",
			name = "Game Tick Weighted Distribution",
			description = "Shifts the random distribution towards the lower end at the target, otherwise it will be an even distribution",
			position = 16,
			section = "delayConfig"
	)
	default boolean tickDelayWeightedDistribution() {
		return false;
	}
}