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
		translator.addHeaderFile("ZumoMotors.h");

		translator.addDefinitionCommand("ZumoMotors motors;");

		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String ret;
		ret = "motors.setRightSpeed(map(constrain(" + translatorBlock.toCode() + ", -100, 100), -100, 100, -200, 200));\n";

		return ret;
	}

}
