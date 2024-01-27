package com.tomtresansky.surpriseme.datamodel.entity

import jakarta.persistence.Entity
import java.io.Serializable

/**
 * Base class for all [Entity]s in LineMan.
 *
 * @param <PK> the type of the primary key for this entity
 */
abstract class AbstractEntity<PK : Serializable> {
    /**
     * Getter for primary key value.
     *
     * @return PK value, if set; else `null`
     */
    abstract fun getPrimaryKey(): PK?

    /**
     * Setter for primary key.
     *
     * Note that we are *not* allowing updating to `null`s.
     *
     * @param value the new PK value to set
     */
    abstract fun setPrimaryKey(value: PK)

    /**
     * Require re-implementing of [Object#toString] to avoid [StackOverflowError] if
     * circular entity associations are followed blindly.
     */
    abstract override fun toString(): String
}
