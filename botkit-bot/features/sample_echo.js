/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 */

module.exports = function(controller) {

    controller.hears('sample','message,direct_message', async(bot, message) => {
        await bot.reply(message, 'I heard a sample message.');
    });

    // wait for a new user to join a channel, then say hi
    controller.on('channel_join', async(bot, message) => {
        await bot.reply(message,'Welcome to the channel!');
    });

    controller.hears(['hi','hello','howdy','hey','aloha','hola','bonjour','oi'],['message'], async (bot,message) => {

      // do something to respond to message
      await bot.reply(message,'Oh hai! , Please enter your emp id to continue');

    });

}
