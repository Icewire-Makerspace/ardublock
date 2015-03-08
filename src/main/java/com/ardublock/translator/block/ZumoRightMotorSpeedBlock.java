package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ZumoRightMotorSpeedBlock extends TranslatorBlock
{

	public ZumoRightMotorSpeedBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		translator.addHeaderFile("QTRSensors.h");
		translator.addHeaderFile("ZumoReflectanceSensorArray.h");
		translator.addHeaderFile("ZumoMotors.h");

		translator.addDefinitionCommand("ZumoMotors motors;");

		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String ret;
		ret = "motors.setRightSpeed(map(" + translatorBlock.toCode() + ", -100, 100, -400, 400));\n";

		return ret;
	}

}
