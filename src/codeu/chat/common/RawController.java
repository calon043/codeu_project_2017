// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package codeu.chat.common;

import codeu.chat.util.Time;
import codeu.chat.util.Uuid;

// RAW CONTROLLER
//
// A controller that grants a large amount of control over how data is inserted
// into the model. If there is a conflict in data, the call will be rejected and
// a null value returned.
public interface RawController {

  // NEW MESSAGE
  //
  // Add a new message to the model with a specific id. If the id is already
  // in use, the call will fail and null will be returned.
  Message newMessage(Uuid id, Uuid author, Uuid conversation, String body, Time creationTime);


  // DELETE MESSAGE
  //
  // Delete a message from the model with a specific id.
  boolean deleteMessage(Uuid msg, Uuid conversation);

  // NEW USER
  //
  // Add a new user to the model with a specific id. If the id is already in
  // use, the call will fail and null will be returned.
  User newUser(Uuid id, String name, Time creationTime);


  // NEW USER
  //
  // Add a new user with a nickname to the model with a specific id. If the id is already in
  // use, the call will fail and null will be returned.
  User newUser(Uuid id, String name, Time creationTime, String nickname);

  // DELETE USER
  //
  // Deletes a User from the model with a specific id.
  User deleteUser(String name, Time deletionTime);



  // NEW CONVERSATION
  //
  // Add a new conversation to the model with a specific if. If the id is
  // already in use, the call will fail and null will be returned.
  Conversation newConversation(Uuid id, String title, Uuid owner, Time creationTime);

  // DELETE CONVERSATION
  //
  //   Delete a message from the server.
  boolean deleteConversation(Uuid conversation);

}
