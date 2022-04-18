package net.httppython.api

import org.simpleyaml.configuration.file.YamlFile

class Language(language : String, path : String) {

    val language = language
    val path = path

    fun create(): String {
        var file = YamlFile(path + language)
        if(file.exists())
            return "This language already exists!"
        file.createNewFile()
        return "The language " + language + " got created."
    }

    fun getTranslation(key : String): String {
        var file = YamlFile(path + language)
        if(!file.exists()) {
            print("This language does not exist.")
            return "Language not found"
        }
        if(!file.contains(key)) {
            file.set(key, "Configure me!")
            print("This translation got created.")
            return file.getString(key)
        }
        return file.getString(key)
    }

    fun createTranslation(key : String) {
        var file = YamlFile(path + language)
        if(!file.exists()) {
            print("This language does not exist.")
        }
        if(file.contains(key)) {
            print("This translation does already exist.")
            return
        }
        file.set(key, "Configure me!")
        print("This translation got created.")
    }

    fun setTranslation(key : String, value : String) {
        var file = YamlFile(path + language)
        if(!file.exists()) {
            print("This language does not exist.")
        }
        if(!file.contains(key)) {
            file.set(key, "Configure me!")
            print("This translation got created.")
            return
        }
        file.set(key, value)
        print("This translation got configured.")
    }

}