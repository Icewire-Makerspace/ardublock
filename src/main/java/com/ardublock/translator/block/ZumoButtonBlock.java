package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ZumoButtonBlock extends TranslatorBlock
{
	
	public ZumoButtonBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String setupCode = "pinMode(12, INPUT_PULLUP);";
		translator.addSetupCommand(setupCode);
		String ret = "(!digitalRead(12))";
		return codePrefix + ret + codeSuffix;
	}

}
