/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 */

 let contacts = new Map()
 contacts.set("655214", {first_name: "Pritam",last_name: "Patil", project_code: "NEMOAXPUK", allocation_until: "18 Dec 2020"});
 contacts.set("655198", {first_name: "Pritam",last_name: "Patil", project_code: "NEMOAXPUK", allocation_until: "18 Dec 2020"});

module.exports = function(controller) {

    // use a function to match a condition in the message
    controller.hears(async (message) => message.text && message.text.toLowerCase() === 'foo', ['message'], async (bot, message) => {
        await bot.reply(message, 'I heard "foo" via a function test');
    });

    // use a regular expression to match the text of the message
    controller.hears(new RegExp(/^\d+$/), ['message','direct_message'], async function(bot, message) {

    if (contacts.has(message.text))
       {
        console.log(JSON.stringify(contacts.get(message.text)));
        message.text = "Emp id "+message.text +" was found...Retrieving details \n "+ JSON.stringify(contacts.get(message.text), null, "\t");;
        }
    else
        message.text = "Emp id "+message.text +" was not Found, please re-enter";

        await bot.reply(message, `${ message.text }`);
    });

    // match any one of set of mixed patterns like a string, a regular expression
    controller.hears(['allcaps', new RegExp(/^[A-Z\s]+$/)], ['message','direct_message'], async function(bot, message) {
        await bot.reply(message,{ text: 'I HEARD ALL CAPS!' });
    });

}